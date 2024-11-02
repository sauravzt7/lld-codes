package io.datajek.spring.basics.movierecommendersystem;

import io.datajek.spring.basics.movierecommendersystem.lesson1.CollaborativeFilter;
import io.datajek.spring.basics.movierecommendersystem.lesson1.ContentBasedFilter;
import io.datajek.spring.basics.movierecommendersystem.lesson1.RecommenderImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

class Counter {

    int count;

    Counter(int count){
        this.count = count;
    }

    public int getCount(){
        return this.count;
    }

    public synchronized  void increment(){
        count += 1;
    }
}

@SpringBootApplication
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(MovieRecommenderSystemApplication.class, args);
//        RecommenderImplementation recommender = new RecommenderImplementation(new CollaborativeFilter());

//        ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);
//        RecommenderImplementation recommenderBean = appContext.getBean(RecommenderImplementation.class);
//        String[] results = recommenderBean.recommendMovies("Finding Dory");
//
//        System.out.println(Arrays.toString(results));


        Counter counter = new Counter(0);

        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i = 0; i <= 90000; i++)counter.increment();
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run(){
                for(int i = 0; i <= 90000; i++)counter.increment();
            }
        });


        t1.start();
        t2.start();

        t1.join();

        t2.join();


        System.out.print(counter.getCount());
    }

}
