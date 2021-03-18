package com.example.myapplication.data.entities.remote

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

/*{
    "adult": false,
    "backdrop_path": "/nlCHUWjY9XWbuEUQauCBgnY8ymF.jpg",
    "belongs_to_collection": {
    "id": 8945,
    "name": "Безумный Макс (Коллекция)",
    "poster_path": "/dhp7PoxYtf72LXFqOFRsWLmD0br.jpg",
    "backdrop_path": "/h4MNLYzr6Cr02iHv3Hpqb9lmTPv.jpg"
},
    "budget": 150000000,
    "genres": [
    {
        "id": 28,
        "name": "боевик"
    },
    {
        "id": 12,
        "name": "приключения"
    },
    {
        "id": 878,
        "name": "фантастика"
    }
    ],
    "homepage": "https://www.warnerbros.com/movies/mad-max-fury-road",
    "id": 76341,
    "imdb_id": "tt1392190",
    "original_language": "en",
    "original_title": "Mad Max: Fury Road",
    "overview": "Вскоре после отмщения за смерть жены и сына, Макс Рокатански покинул ряды «Основного силового патруля» и уехал в глушь, где скитается в одиночестве, пока мир медленно падает в последствии нефтяного кризиса и глобальной войны. Не имея ничего, кроме своей машины «Перехватчик», Максу предстоит научиться, как выжить в пост-апокалиптической пустоши и сражаться с жестокими, безжалостными воинами, которые населяют её.",
    "popularity": 56.335,
    "poster_path": "/3tdXXuXIWU26LffOntbYFfX1SNN.jpg",
    "production_companies": [
    {
        "id": 2537,
        "logo_path": null,
        "name": "Kennedy Miller Productions",
        "origin_country": "AU"
    },
    {
        "id": 174,
        "logo_path": "/ky0xOc5OrhzkZ1N6KyUxacfQsCk.png",
        "name": "Warner Bros. Pictures",
        "origin_country": "US"
    },
    {
        "id": 41624,
        "logo_path": "/wzKxIeQKlMP0y5CaAw25MD6EQmf.png",
        "name": "RatPac-Dune Entertainment",
        "origin_country": "US"
    },
    {
        "id": 79,
        "logo_path": "/tpFpsqbleCzEE2p5EgvUq6ozfCA.png",
        "name": "Village Roadshow Pictures",
        "origin_country": "US"
    }
    ],
    "production_countries": [
    {
        "iso_3166_1": "AU",
        "name": "Australia"
    },
    {
        "iso_3166_1": "US",
        "name": "United States of America"
    },
    {
        "iso_3166_1": "ZA",
        "name": "South Africa"
    }
    ],
    "release_date": "2015-05-13",
    "revenue": 378858340,
    "runtime": 120,
    "spoken_languages": [
    {
        "english_name": "English",
        "iso_639_1": "en",
        "name": "English"
    }
    ],
    "status": "Released",
    "tagline": "Какой чудесный день",
    "title": "Безумный Макс: Дорога ярости",
    "video": false,
    "vote_average": 7.5,
    "vote_count": 17748
}*/

data class MovieApi(
    @SerializedName("title") val title: String?,
    @SerializedName("revenue") val revenue: BigDecimal?,
    @SerializedName("release_date") val release_date: String?,
    @SerializedName("poster_path") val poster_path: String?,
)