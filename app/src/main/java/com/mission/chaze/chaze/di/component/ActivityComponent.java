

package com.mission.chaze.chaze.di.component;

import com.mission.chaze.chaze.di.PerActivity;
import com.mission.chaze.chaze.di.module.ActivityModule;
import com.mission.chaze.chaze.screens.Authentication.LoginActivity;

import com.mission.chaze.chaze.screens.Cart.CartActivity;

import com.mission.chaze.chaze.screens.Authentication.SignUpActivity;

import com.mission.chaze.chaze.screens.Category.CategoryActivity;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.EcommerceFragment;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByProducts.ShopByProductsFragment;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops.ShopByShopsFragment;
import com.mission.chaze.chaze.screens.Homepage.Food.FoodFragment;
import com.mission.chaze.chaze.screens.Homepage.Home.HomeFragment;
import com.mission.chaze.chaze.screens.Homepage.HomeActivity;
import com.mission.chaze.chaze.screens.Proflie.ProfileActivity;
import com.mission.chaze.chaze.screens.Splash.SplashActivity;
import com.mission.chaze.chaze.screens.SubCategory.SubCategoryActivity;
import com.mission.chaze.chaze.screens.base.BaseActivity;
import com.mission.chaze.chaze.screens.search.SearchActivity;

import dagger.Component;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(HomeActivity activity);

    void inject(SplashActivity activity);


    void inject(ProfileActivity profileActivity);


    void inject(SearchActivity searchActivity);

    void inject(HomeFragment homeFragment);

    void inject(EcommerceFragment ecommerceFragment);

    void inject(ShopByProductsFragment shopByProductsFragment);

    void inject(ShopByShopsFragment shopByShopsFragment);

    void inject(FoodFragment foodFragment);

    void inject(LoginActivity loginActivity);


    void inject(CartActivity cartActivity);

    void inject(SignUpActivity signUpActivity);

    void inject(CategoryActivity categoryActivity);

    void inject(SubCategoryActivity subCategoryActivity);
}
