DROP DATABASE if exists SpotIFy;

CREATE DATABASE SpotIFy;
USE SpotIFy; 

CREATE TABLE User (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(50) NOT NULL,
    birth_date DATE,
    favorite_genres TEXT
);

CREATE TABLE Artist (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    view_count INT,
    bio TEXT,
    verified BOOLEAN,
    genre TEXT
);

CREATE TABLE Songs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    listener_count INT,
    album_id VARCHAR(255),
    duration TIME,
    artist_id INT,
    FOREIGN KEY (artist_id) REFERENCES Artist(id)
);

CREATE TABLE Album (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    artist_id INT,
    year INT,
    songs VARCHAR(255) NOT NULL,
    listener_count INT,
    FOREIGN KEY (artist_id) REFERENCES Artist(id)
);

CREATE TABLE Playlist (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    user_id INT,
    bio TEXT,
    songs_id TEXT,
    likes INT,
    FOREIGN KEY (user_id) REFERENCES User(id)
);