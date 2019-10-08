package com.tombe.yesid.example.movies.util

import com.tombe.yesid.example.movies.model.ArrayGeneral
import com.tombe.yesid.example.movies.model.Movie
import com.tombe.yesid.example.movies.model.Serie

object Data {

    // Data Movie offline
    val dataMov:MutableList<Movie> = mutableListOf(

        Movie(155.023, 606, "/a4BfxRK8dBgbQqbRxPs8kmLd8LG.jpg",
            429203, "en", "The Old Man & the Gun",
            listOf(ArrayGeneral(18,"Drama"), ArrayGeneral(35, "Comedy"), ArrayGeneral(80, "Crime")),
            6.3,"The true story of Forrest Tucker, from his audacious escape from San Quentin at the age of 70 to an unprecedented string of heists that confounded authorities and enchanted the public. Wrapped up in the pursuit are a detective, who becomes captivated with Forrest’s commitment to his craft, and a woman, who loves him in spite of his chosen profession.",
            "2018-09-27", 0, "http://www.foxsearchlight.com/theoldmanandthegun",
            93, listOf( ArrayGeneral(51513, "Condé Nast Entertainment"), ArrayGeneral(1205, "Endgame Entertainment"),
                ArrayGeneral(2870, "Identity Films"), ArrayGeneral(14634, "Sailor Bear"), ArrayGeneral(316, "Wildwood Enterprises"))),

        Movie(265.852, 1323, "/zfE0R94v1E8cuKAerbskfD3VfUt.jpg",
            474350, "en", "It Chapter Two",
            listOf(ArrayGeneral(27,"Horror")), 6.3,
            "27 years after overcoming the malevolent supernatural entity Pennywise, the former members of the Losers' Club, who have grown up and moved away from Derry, are brought back together by a devastating phone call.",
            "2019-09-04", 79000000, "http://www.it-movie.net/",
            169, listOf(ArrayGeneral(2723, "Lin Pictures"), ArrayGeneral(12, "New Line Cinema"), ArrayGeneral(174, "Warner Bros. Pictures"),
                ArrayGeneral(829, "Vertigo Entertainment"), ArrayGeneral(87671, "KatzSmith Productions"))),

        Movie(150.755, 2494, "/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg",
            301528, "en", "Toy Story 4",
            listOf(ArrayGeneral(12,"Adventure"), ArrayGeneral(16,"Animation"), ArrayGeneral(35,"Comedy"), ArrayGeneral(10751,"Family"), ArrayGeneral(14,"Fantasy")), 6.3,
            "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \\\"Forky\\\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.",
            "2019-06-19", 175000000, "https://www.pixar.com/feature-films-toy-story-4",
            100, listOf(ArrayGeneral(2, "Walt Disney Pictures"), ArrayGeneral(3, "Pixar"))),

        Movie(146.232, 362, "/kTQ3J8oTTKofAVLYnds2cHUz9KO.jpg",
            522938, "en", "Rambo: Last Blood",
            listOf(ArrayGeneral(28, "Action"), ArrayGeneral(53, "Thriller")), 6.1,
            "When John Rambo's niece travels to Mexico to find the father that abandoned her and her mother, she finds herself in the grasps of Calle Mexican sex traffickers. When she doesn't return home as expected, John learns she's crossed into Mexico and sets out to get her back and make them pay.",
            "2019-09-19", 0, "https://rambo.movie/", 100, listOf(ArrayGeneral(1632, "Lionsgate"), ArrayGeneral(1020, "Millennium Films"))),

        Movie(popularity=128.585, vote_count=2802, poster_path="/ziEuG1essDuWuC5lpWUaw1uXY2O.jpg",
            id=458156, original_language="en", original_title="John Wick: Chapter 3 - Parabellum", genres= listOf(ArrayGeneral(id=28, name="Action"), ArrayGeneral(id=53, name="Thriller"), ArrayGeneral(id=80, name="Crime")), vote_average=7.1,
            overview="Super-assassin John Wick returns with a \$14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin’s guild, the High Table, John Wick is excommunicado, but the world’s most ruthless hit men and women await his every turn.",
            release_date="2019-05-15", budget=55000000, homepage="https://www.johnwick.movie",
            runtime=131, production_companies= listOf(ArrayGeneral(id=491, name="Summit Entertainment"), ArrayGeneral(id=3528, name="Thunder Road Pictures"), ArrayGeneral(id=113619, name="87Eleven Productions")))

    )

    //Data Serie offline
    val dataSer:MutableList<Serie> = mutableListOf(

        Serie(popularity=171.065, vote_count=1381, poster_path="/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg",
            id=60625, original_language="en", genres= listOf(ArrayGeneral(id=10765, name="Sci-Fi & Fantasy"), ArrayGeneral(id=10759, name="Action & Adventure"), ArrayGeneral(id=16, name="Animation"), ArrayGeneral(id=35, name="Comedy")), vote_average=8.5,
            overview="Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
            homepage="http://www.adultswim.com/videos/rick-and-morty", original_name="Rick and Morty", number_of_seasons=4, origin_country= listOf("US"), created_by= listOf(ArrayGeneral(id=57194, name="Dan Harmon"), ArrayGeneral(id=1245733, name="Justin Roiland")),
            first_air_date="2013-12-02"),

        Serie(popularity=123.234, vote_count=3538, poster_path="/1yeVJox3rjo2jBKrrihIMj7uoS9.jpg",
            id=1396, original_language="en", genres= listOf(ArrayGeneral(id=18, name="Drama")), vote_average=8.4,
            overview="When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
            homepage="http://www.amc.com/shows/breaking-bad", original_name="Breaking Bad", number_of_seasons=5, origin_country= listOf("US"),
            created_by= listOf(ArrayGeneral(id=66633, name="Vince Gilligan")), first_air_date="2008-01-20"),

        Serie(popularity=92.905, vote_count=2651, poster_path="/x2LSRK2Cm7MZhjluni1msVJ3wDF.jpg",
            id=66732, original_language="en", genres= listOf(ArrayGeneral(id=18, name="Drama"), ArrayGeneral(id=9648, name="Mystery"), ArrayGeneral(id=10765, name="Sci-Fi & Fantasy")),
            vote_average=8.3, overview="When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces, and one strange little girl.",
            homepage="https://www.netflix.com/title/80057281", original_name="Stranger Things", number_of_seasons=3, origin_country= listOf("US"),
            created_by= listOf(ArrayGeneral(id=1179422, name="Ross Duffer"), ArrayGeneral(id=1179419, name="Matt Duffer")), first_air_date="2016-07-15"),

        Serie(popularity=32.088, vote_count=866, poster_path="/dg7NuKDjmS6OzuNy33qt8kSkPA1.jpg",
            id=1438, original_language="en", genres= listOf(ArrayGeneral(id=18, name="Drama"), ArrayGeneral(id=80, name="Crime")), vote_average=8.3,
            overview="Told from the points of view of both the Baltimore homicide and narcotics detectives and their targets, the series captures a universe in which the national war on drugs has become a permanent, self-sustaining bureaucracy, and distinctions between good and evil are routinely obliterated.",
            homepage="http://www.hbo.com/the-wire", original_name="The Wire", number_of_seasons=5, origin_country= listOf("US"),
            created_by= listOf(ArrayGeneral(id=1218279, name="David Simon")), first_air_date="2002-06-02")

    )

}