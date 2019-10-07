package com.tombe.yesid.example.movies.util

import com.tombe.yesid.example.movies.model.ArrayGeneral
import com.tombe.yesid.example.movies.model.Movie
import com.tombe.yesid.example.movies.model.Serie

object Data {

    val data:MutableList<Movie> = mutableListOf(Movie(172.1,603, "/a4BfxRK8dBgbQqbRxPs8kmLd8LG.jpg",
    429203, "en", "The Old Man & the Gun", listOf(),6.3,
    "The true story of Forrest Tucker, from his audacious escape from San Quentin at the age of 70 to an unprecedented string of heists that confounded authorities and enchanted the public. Wrapped up in the pursuit are a detective, who becomes captivated with Forrest’s commitment to his craft, and a woman, who loves him in spite of his chosen profession.",
    "2018-09-28", 2500000, "http://www.foxsearchlight.com/theoldmanandthegun",
    93, listOf()),
        Movie(239.35,1269, "/zfE0R94v1E8cuKAerbskfD3VfUt.jpg",
    474350, "en", "It Chapter Two", listOf(),
    7.1,
    "27 years after overcoming the malevolent supernatural entity Pennywise, the former members of the Losers' Club, who have grown up and moved away from Derry, are brought back together by a devastating phone call.",
    "2019-09-06", 79000000, "http://www.it-movie.net/",
    169, listOf()),
        Movie(147.755,2456, "/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg",
    301528,  "en", "Toy Story 4", listOf(),
    7.6,
    "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \\\"Forky\\\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.",
    "2019-06-21", 175000000, "https://www.pixar.com/feature-films-toy-story-4",
    100, listOf()))


    val data2:MutableList<Serie> = mutableListOf(
        Serie(150.2,35,
            "/a4BfxRK8dBgbQqbRxPs8kmLd8LG.jpg",1,"es",
            listOf(),65.3,"Overview....", null,"jokeerr",11,
            listOf("Pais 1", "Pais 2"), listOf(),null),
        Serie(150.2,35,
            "/a4BfxRK8dBgbQqbRxPs8kmLd8LG.jpg",1,"es",
            listOf(),39.7,"Overview....", null,"Otro joker",11,
            listOf("Colombia", "Peru"), listOf(),null)
    )

}