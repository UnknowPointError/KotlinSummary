package Year2022.Month04.Day11;
/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/11 18:55 周一
@Description: RxJava
*/

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxJava {
    public static void main(String[] args) {
        Observable.range(1, 100)
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer) throws Throwable {
                        return Observable.just(integer)
                                .subscribeOn(Schedulers.io())
                                .map(new Function<Integer, String>() {
                                    @Override
                                    public String apply(Integer integer) throws Throwable {
                                        return integer.toString();
                                    }
                                });
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Throwable {
                        System.out.println(s);
                    }
                });

    }
}
