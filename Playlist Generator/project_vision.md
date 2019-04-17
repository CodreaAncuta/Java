# Playlist Generator Vision

# Introduction
The purpose of this document is to collect, analyze, and define high-level needs and features of the Playlist Generator. It focuses on the capabilities needed by the stakeholders and the target users, and why these needs exist. The details of how the Playlist Generator fulfills these needs are detailed in the use-case and supplementary specifications.

The introduction of the Vision document provides an overview of the entire document. It includes the purpose, scope, definitions, acronyms, abbreviations, references, and overview of this Vision document.

## Purpose
The purpose of this document is to present and introduce the Playlist Generator Application. This is a desktop application which desires to facilitate the users experience in making fully customized playlists, or having one be generated for him based on his own musical preferences and his history of played songs. Furthermore, it will be an interactive application, the user can easily browse for songs and give them an rating, therefore a rank of the song can be kept and also recommand some of their favourites to their friends, which they can add or remove from their list at any time.

## Scope
This Vision Document applies to the PGA Playlist Generator Application, which will be developed by Codrea Ancuta-Maria. The application will be developed as a desktop application. The PGA will provide a way for every person/user to more easily create their own playlists or choose to have generated a playlist for them, and support functions that help the user recomand songs, which are detailed elsewhere in this document.  

The following features will be covered by the Playlist Generator Application:

- User authentication: regular user and administrator
- The regular user can search the music list for songs by singer, genre, top views
- The user can create a playlist with given selected songs and also, remove items from a playlist
- The administrator can perform CRUD on songs and on regular user information, and generate a report with the users playlists
- The regular users can add other users as friends and also suggest songs to them
- An user gets a live notification when a song is suggested by a friend, having the possibility to accept it or not. If accepted, that song is added to the playlist
- Regular users can rate (once) the songs (between 1-5 stars) and also search by rating. The admin user can edit the ratings.
- Users can remove friends from their list of friends
- The system can generate upon request, playlists based on user's history of played songs (e.g., by genre)


## Definitions, Acronyms, and Abbreviations
**PGA** **-** Playlist Generator Application

**User** **-**  a person who interacts directly with the product. A user can have different roles with respect to the system (e.g. administrator, mediator, regular user) .

**GUI** **-** Graphical User Interface.

**Administrator** **-**  is a privileged user who is responsible for managing user accounts, and managing resources (ex. adding or removing songs, etc).

**End user** **-**  is a person who ultimately uses or is intended to ultimately use a product.

**Desktop application** **-**  an application that it runs on a PC operating system, it has a GUI, it does not run inside a web browser.

**Stakeholder** **-** a person or group who has an interest in an enterprise/project and whose support is required in order for the project to be successful.

**CRUD -** create, retrieve, update, delete

## References
1. Vision Document Template
2. Vision Document. Team Obiwan.

## Overview
Presented below in the document are the stakeholder and user descriptions, the positioning and the requirements of the product, which intend to offer a more clear view of the application and the uses of the PGA.

# Positioning
## Problem Statement

|||
|----|------- |
| **The problem of** | people not knowing what songs to listen anymore and having the desire for new playlists
| **affects**  | anyone who wishes for a music application which generates playlist based on their personal preferences
| **the impact of which is** |  having difficulty in seeking the songs to make a full, complete playlist
| **a successful solution would be** | a simple desktop application that can be easily used by anyone. The product would provide users with means of expressing themselves through their selection of songs in their personal playlists. It would also suggest potential playlists for the user based on what genres he listened to. The product would also support efficient means of suggesting and sharing some of the users' favourite songs with other friends.

## Product Position Statement

|||
|----|------- |
| **For** | every person with an affinity and love for music and which likes to listen songs |
| **Who** | like to be organized with their favourites and discover new good music |
| **The** | Playlist Generator Application (PGA) is a software application
| **That** | provides the ability to stay organized with your music and find soothing music for the personal preferences of the users, that it's easily shared with others
| **Unlike** | currently available systems that do not think in such depth the ways of generating playlist to facilitate the user experience
| **Our product** | provides users with means of expressing themselves through playlists that they've created and also sharing their music taste with others. This is accomplished by adding friends and suggesting a song to them. The product also supports efficient means of having playlists generated.


# Stakeholder and User Descriptions
The target market segment includes people with the age of 12+. Also in the target market segment are people who like being organized with their music and spend lots of time listening to it. The users are anticipated to be consumers who have a personal computer since the product will be developed as a desktop application, and also people which have a liking for music.

## Stakeholder Summary

### Stakeholder 1
* **Name**: Requirements Engineers.
* **Description**: This stakeholder works with customers and other stakeholders to translate needs of the demographic of customers into requirements.
* **Responsibilities**: This stakeholder:
    * Specifies domain
    * Ensures that the system will have a set of non-functional and functional requirements
    * Ensures that there will be a market demand for the product’s features by correctly translating the need of the customers
    * Monitors the project’s progress
    * Refines requirements as needed

### Stakeholder 2
* **Name**: Software Architect.
* **Description**: This stakeholder represents the main pillar in the development of the Playlist Generator Application (PGA).
* **Responsibilities**: The stakeholder:
    * Ensures that the system will be maintainable
    * Responsible for overall architecture of the system
    * Guides overall design and implementation of system


## User Summary

### User 1
* **Name**: Any person who owns and knows how to use a personal computer.
* **Description**: Primary end user of the system.
* **Responsibilities**: Uses application to play music and create personalized playlists as they wish. Also, can request the generation of a playlist to the system, or suggest songs to their friends.
* **Stakeholder**: Self.

### User 2
* **Name**: Administrator of the system.
* **Description**: End user of the system.
* **Responsibilities**: 
   * Produces reports
   * CRUD on songs and the users' information.
* **Stakeholder**: Self.

## User Environment
1. The PGA application will be used by people, regardless of age, which have access to a computer. 
2. The system will work on a Windows computing platform. Future platforms may be Linux, and macOS.
3. The application is a desktop application with an enjoyable interface. The GUI suggests a clear way to use the app.
4. The administrator should be able to generate reports based on the information that he has access to.
5. The administrator should not need to use the PGA system to communicate with the users.
6. The users shall be able to search easily for songs and add them to their playlists, request playlists from the system and share their music taste with other users that use the PGA, which they can add or remove from their list of friends.

# Product Requirements

## Applicable Standards 
The PGA must comply with existing standards in the musical services field for having access to all kind of songs, categorized by genre or artists.

## System Requirements
The system must run on an Window OS based computer.

## Performance Requirements
The system must respond quick to the users' actions. No other performance requirements specified.

## Environmental Requirements
None specified.

# Bibliography

- [Markdown online editor](http://dillinger.io/)
- [Markdown Tutorial](https://www.markdowntutorial.com )
- [Mastering Markdown](https://guides.github.com/features/mastering-markdown/)
- [HOPE project](https://www.utdallas.edu/~chung/RE/Presentations10F/Team-hope/1%20-%20VisionDoc.pdf)
- [Writing the good vision](https://www.oreilly.com/library/view/making-things-happen/9780596517717/ch04.html)
- [Bringing it all together: The Vision Document](http://www.informit.com/articles/article.aspx?p=30162&seqNum=4)
