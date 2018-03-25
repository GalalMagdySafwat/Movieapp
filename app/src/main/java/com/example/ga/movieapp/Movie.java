package com.example.ga.movieapp;



public class Movie {

        private String originalTitle ;
        private String moviePoster ;
        private String overView ;
        private String userRating ;
        private String releaseDate;


        public Movie(String originalTitle, String moviePoster, String overView, String userRating, String releaseDate) {
            this.originalTitle = originalTitle;
            this.moviePoster = moviePoster;
            this.overView = overView;
            this.userRating = userRating;
            this.releaseDate = releaseDate;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public String getMoviePoster() {
            return moviePoster;
        }

        public String getOverView() {
            return overView;
        }

        public String getUserRating() {
            return userRating;
        }

        public String getReleaseDate() {
            return releaseDate;
        }



    }
