[![GitHub Repo](https://img.shields.io/badge/GitHub-Project-blue)](https://github.com/Sefat3674/OOP-project-with-Kotlin)
[![Language](https://img.shields.io/badge/Kotlin-1.8-orange)](https://kotlinlang.org/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)




# 🎬 Movie Recommendation System (OOP in Kotlin)

A console-based **Movie Recommendation System** implemented in **Kotlin** using **Object-Oriented Programming (OOP)** principles.  
Users can view movies, rate them, get recommendations, and track their watched movies.

---

## **Features**

1. **View All Movies** – Lists all movies in the library with type and year.  
2. **Rate a Movie** – Allows the user to rate any movie (1–5 stars). Updates user genre preferences dynamically.  
3. **Get Recommendations** – Displays top recommended movies for the user based on ratings and preferences.  
4. **Add a New Movie** – Add new Action, Drama, or Comedy movies dynamically.  
5. **View Watched Movies & Ratings** – Shows all movies rated by the user.  
6. **Exit** – Exit the program gracefully.  

---

## **OOP Principles Used**

- **Encapsulation** – User preferences, ratings, and watched movies are managed inside the `User` class.  
- **Inheritance** – `Action`, `Drama`, `Comedy` inherit from the base `Movie` class.  
- **Polymorphism** – `getRecommendationScore(user: User)` is overridden in subclasses for different scoring logic.  
- **Abstraction** – Abstract class `RecommendationActions` defines actions for rating and recommending movies.  

---

## **Project Structure**

<img width="441" height="428" alt="image" src="https://github.com/user-attachments/assets/7a236c42-905f-4f65-be45-ab8e7abba42f" />



---
## **UML Diagram**
<img width="428" height="392" alt="image" src="https://github.com/user-attachments/assets/43d7d99e-d932-4438-84dc-8383b3f72c4f" /><br>
<img width="428" height="392" alt="image" src="https://github.com/user-attachments/assets/b242e6c4-c3b9-4f7c-87a7-f179f3612501" /><br>
<img width="428" height="392" alt="image" src="https://github.com/user-attachments/assets/f13ec88c-092a-41b2-97a9-c1e2b3878b03" /> <img width="600" height="500" alt="ChatGPT Image Sep 12, 2025, 03_31_05 PM" src="https://github.com/user-attachments/assets/06e30cdd-0316-444a-a7b7-499ac2981b52" />



## **How to Run**

1. **Compile the project** (from `src` folder):

```bash
kotlinc models/*.kt library/*.kt Main.kt -include-runtime -d MovieRecommendationSystem.jar
java -jar MovieRecommendationSystem.jar
```
## **Sample of Usage**

🎬 Welcome to the Movie Recommendation System!

--- Menu ---
1. View All Movies
2. Rate a Movie
3. Get Recommendations
4. Exit
5. Add a New Movie
6. View Watched Movies & Ratings
Choose an option (1-6):


## *Technologies Used*
Kotlin
Object-Oriented Programming (OOP)
JVM


---

If you want, I can also **create a shorter, GitHub-ready version with badges and emoji icons** to make it look more aesthetic for your repository.  

Do you want me to do that?

## *Made by*
## SEFAT AHMED
