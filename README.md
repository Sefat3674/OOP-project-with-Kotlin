# Office Attendance System (Kotlin)

A console-based Office Attendance Management System implemented in **Kotlin**, allowing **employees** and **officers** to manage and track attendance records efficiently.

---

## Features

### Employee
- Sign up with a unique Employee ID.
- Login using Employee ID.
- Add daily attendance with:
  - Date (automatically set to today)
  - Arrival time
  - Automatic late detection (threshold: 08:30)
  - Optional late cause
- View monthly attendance records.

### Officer
- Sign up with a unique Officer ID and username.
- Login using username and password.
- View specific employee attendance records.

---

## Project Structure

<img width="313" height="399" alt="image" src="https://github.com/user-attachments/assets/ad2b2ff9-5076-4eff-bd95-d4d1fad50174" />

- **model/** – Kotlin data classes: Employee, Officer, Attendance.  
- **data/** – Singleton `DataManager` for storing employees and officers.  
- **utils/** – Utility classes for date operations and unique ID generation.  
- **main/** – Main program entry point with CLI menu.  

---

## Technologies
- Kotlin 1.8+  
- Console-based CLI application  
- JDK 17+ recommended  

---

## Getting Started

### Compile

```bash
kotlinc src/com/model/*.kt src/com/data/*.kt src/com/utils/*.kt src/com/main/*.kt -include-runtime -d officeattendance.jar
java -jar officeattendance.jar
```

<img width="358" height="330" alt="image" src="https://github.com/user-attachments/assets/70732a20-8e10-4edf-bdf0-afeac18dcbe6" /><br>
<img width="464" height="188" alt="image" src="https://github.com/user-attachments/assets/536da629-bf5c-4ac1-b64f-0ef1c33c5870" />


---

If you want, I can also **update it to include a small UML diagram and sample console screenshots** so it looks professional for GitHub.  

Do you want me to do that?

### Made by
## SEFAT

##### This is my Continous Project. I will update regularly


