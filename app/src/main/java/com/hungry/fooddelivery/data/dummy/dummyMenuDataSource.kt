package com.hungry.fooddelivery.data.dummy

import com.hungry.fooddelivery.model.Menu

interface DummyMenuDataSource{
    fun getMenu(): List<Menu>
}
class DummyMenuDataSourceImpl : DummyMenuDataSource {
    override fun getMenu(): List<Menu> =
        listOf(
            Menu(
                id = 1,
                nameOfMenu = "Ayam Bakar",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_grilled_chicken.jpg?raw=true",
                priceOfMenu = 50000.0,
                descOfMenu = "Ayam Bakar adalah hidangan lezat dengan ayam yang dipanggang dan bumbu khas Indonesia.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 2,
                nameOfMenu = "Ayam Goreng",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_fried_chicken.jpg?raw=true",
                priceOfMenu = 45000.0,
                descOfMenu = "Ayam Goreng adalah hidangan klasik dengan ayam yang digoreng garing dan renyah.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 3,
                nameOfMenu = "Ayam Geprek",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_geprek_chicken.jpg?raw=true",
                priceOfMenu = 48000.0,
                descOfMenu = "Ayam Geprek adalah hidangan ayam yang digeprek dan disajikan dengan sambal pedas.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 4,
                nameOfMenu = "Burger",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_burger.jpg?raw=true",
                priceOfMenu = 55000.0,
                descOfMenu = "Burger adalah hidangan cepat saji yang terdiri dari daging, sayuran, dan saus di dalam roti.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 5,
                nameOfMenu = "Dimsum",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_dimsum.jpg?raw=true",
                priceOfMenu = 30000.0,
                descOfMenu = "Dimsum adalah hidangan Cina yang terdiri dari berbagai jenis makanan kecil seperti pangsit dan bakpao.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 6,
                nameOfMenu = "Pizza",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_pizza.jpg?raw=true",
                priceOfMenu = 65000.0,
                descOfMenu = "Pizza adalah hidangan Italia yang terdiri dari adonan tipis yang diisi dengan berbagai topping seperti keju, tomat, dan daging.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 7,
                nameOfMenu = "Sate Ayam",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_chicken_satay.jpg?raw=true",
                priceOfMenu = 40000.0,
                descOfMenu = "Sate Ayam adalah hidangan Indonesia yang terdiri dari potongan-potongan ayam yang ditusuk dan dipanggang dengan bumbu kacang.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 8,
                nameOfMenu = "Sate Kambing",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_lamb_satay.jpg?raw=true",
                priceOfMenu = 60000.0,
                descOfMenu = "Sate Kambing adalah hidangan Indonesia yang terbuat dari daging kambing yang dipanggang dengan bumbu kacang.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 9,
                nameOfMenu = "Sate Kulit Ayam",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_chicken_skin_satay.jpg?raw=true",
                priceOfMenu = 35000.0,
                descOfMenu = "Sate Kulit Ayam adalah hidangan Indonesia yang terbuat dari kulit ayam yang dipanggang dengan bumbu kacang.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 10,
                nameOfMenu = "Kentang Goreng",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_french_fries.jpg?raw=true",
                priceOfMenu = 25000.0,
                descOfMenu = "Kentang Goreng adalah hidangan kentang yang digoreng garing dan sering disajikan dengan saus.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 11,
                nameOfMenu = "Latte",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_latte.jpg?raw=true",
                priceOfMenu = 35000.0,
                descOfMenu = "Latte adalah minuman kopi yang terbuat dari espresso dan susu, sering dihiasi dengan foam susu di atasnya.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 12,
                nameOfMenu = "Susu Stroberi",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_strawberry_milk.jpg?raw=true",
                priceOfMenu = 30000.0,
                descOfMenu = "Susu Stroberi adalah minuman susu dengan rasa stroberi yang manis dan segar.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 13,
                nameOfMenu = "Sushi",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_sushi.jpg?raw=true",
                priceOfMenu = 70000.0,
                descOfMenu = "Sushi adalah hidangan Jepang yang terdiri dari nasi yang dibentuk dengan topping seperti ikan, sayuran, atau telur.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                id = 14,
                nameOfMenu = "Spaghetti",
                imgUrlMenu = "https://github.com/dyanpk/FoodApp_CH3/blob/feature/feature_page_home/asset/food_image/img_spaghetti.jpg?raw=true",
                priceOfMenu = 40000.0,
                descOfMenu = "Spaghetti adalah hidangan Italia yang terdiri dari pasta yang disajikan dengan berbagai jenis saus.",
                locationOfMenu = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationUrlMenu = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            )
        )
}