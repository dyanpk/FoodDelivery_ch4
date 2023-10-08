package com.hungry.fooddelivery.data.dummy

import com.hungry.fooddelivery.model.Category

interface DummyCategoryDataSource{
    fun getMenuCategory(): List<Category>
}

class DummyCategoryDataSourceImpl : DummyCategoryDataSource{
    override fun getMenuCategory(): List<Category> =
        listOf(
            Category(
                nameOfCategory = "Breakfast",
                imgUrlCategory = "https://github.com/dyanpk/assetChapter4/blob/master/app/src/main/res/drawable/img_breakfast.png?raw=true"
            ),
            Category(
                nameOfCategory = "Chicken",
                imgUrlCategory = "https://github.com/dyanpk/assetChapter4/blob/master/app/src/main/res/drawable/img_chicken.png?raw=true"
            ),
            Category(
                nameOfCategory = "Rice",
                imgUrlCategory = "https://github.com/dyanpk/assetChapter4/blob/master/app/src/main/res/drawable/img_rice.png?raw=true"
            ),
            Category(
                nameOfCategory = "Snack",
                imgUrlCategory = "https://github.com/dyanpk/assetChapter4/blob/master/app/src/main/res/drawable/img_snack.png?raw=true"
            ),
            Category(
                nameOfCategory = "Drinks",
                imgUrlCategory = "https://github.com/dyanpk/assetChapter4/blob/master/app/src/main/res/drawable/img_drinks.png?raw=true"
            ),
            Category(
                nameOfCategory = "Seafood",
                imgUrlCategory = "https://github.com/dyanpk/assetChapter4/blob/master/app/src/main/res/drawable/img_seafood.png?raw=true"
            ),
            Category(
                nameOfCategory = "Salad",
                imgUrlCategory = "https://github.com/dyanpk/assetChapter4/blob/master/app/src/main/res/drawable/img_salad.png?raw=true"
            ),
            Category(
                nameOfCategory = "Noodles",
                imgUrlCategory = "https://github.com/dyanpk/assetChapter4/blob/master/app/src/main/res/drawable/img_noodles.png?raw=true"
            ),
            Category(
                nameOfCategory = "Fast Food",
                imgUrlCategory = "https://github.com/dyanpk/assetChapter4/blob/master/app/src/main/res/drawable/img_fast_food.png?raw=true"
            )
        )
}