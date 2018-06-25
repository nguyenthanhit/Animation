package sg.vinova.myapplication.util;
/* *
 *  Created by JAY on 20/06/2018
 */

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sg.vinova.myapplication.model.Food;
import sg.vinova.myapplication.model.Review;

public class Util {

    public static String[] images() {
        return new String[]{
                "https://cdn-a.william-reed.com/var/wrbm_gb_food_pharma/storage/images/publications/food-beverage-nutrition/foodnavigator.com/article/2017/12/06/why-sugar-and-why-so-much-who-investigates-the-food-industry-s-sweet-tooth/7624387-1-eng-GB/Why-sugar-and-why-so-much-WHO-investigates-the-food-industry-s-sweet-tooth_wrbm_large.jpg",
                "https://bluewater.co.uk/sites/bluewater/files/styles/image_spotlight_large/public/images/spotlights/burger-cropped.jpg?itok=SeFYMFP6",
                "https://cdn.cnn.com/cnnnext/dam/assets/171027052520-processed-foods-exlarge-tease.jpg",
                "https://www.mcdonalds.com/content/dam/usa/documents/mcdelivery/mcdelivery_new11.jpg",
                "http://www.kebuena.com.mx/wp-content/uploads/2016/09/tacos.jpg",
                "https://i.pinimg.com/originals/fd/22/af/fd22af001ec6d7b09465b5fd0ad75310.jpg",
                "https://www.mjlah.com/wp-content/uploads/%D8%B3%D9%85%D9%83-5.jpg",
                "http://static1.bestie.vn/Mlog/UploadThumbs/201703/0thumb-20170310130553.jpg",
                "https://www.foodandfriends.org/wp-content/uploads/2017/03/IMG_0196-505x306.jpg",
                "http://www.appetizer.com.sg/contents//images/09.jpg"
        };
    }

    public static List<Food> foods() {
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int rating = new Random().nextInt(5);
            foods.add(new Food("Name " + i, rating
                    , images()[i % images().length],
                    images()[i % images().length], i * 10, i * 5));
        }

        return foods;
    }


    public static List<Review> reviews() {
        List<Review> reviews = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            reviews.add(new Review("User " + i,
                    images()[i % images().length],
                    "Ahihi ngon quá",
                    "21/6/2018",
                    i % 5));
        }
        return reviews;
    }


    public static void loadImage(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .applyDefaultRequestOptions(new RequestOptions().override(1024, 1024))
                .asBitmap().load(url).into(imageView);
    }
}
