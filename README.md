# Hospital Management System (Kotlin)

A **console-based Hospital Management System** built in Kotlin.  
It allows **patients to request appointments**, **doctors to accept and prescribe**, and **patients to buy medicines and generate bills**.

---

## **Project Structure**

<img width="475" height="330" alt="image" src="https://github.com/user-attachments/assets/116b5fb8-75d5-4244-ad3b-8a6fc5eb1d65" />

## UML Diagram
<img width="442" height="284" alt="image" src="https://github.com/user-attachments/assets/fffaefd8-a9d7-4486-9e0b-6ff49f2fef07" /><br>
<img width="763" height="379" alt="image" src="https://github.com/user-attachments/assets/9398581d-fb84-4300-99e7-20dac01a88dc" /><br>
<img width="582" height="315" alt="image" src="https://github.com/user-attachments/assets/6b4e438d-55b0-4936-bec2-4de602b8787a" /><br>
<img width="452" height="248" alt="image" src="https://github.com/user-attachments/assets/870349d0-6279-4f42-a509-aa67bf30382f" /><br>
<img width="443" height="269" alt="image" src="https://github.com/user-attachments/assets/4b4ff4b9-09bd-4ea2-876d-c9ef9d26175b" /><br>
<img width="562" height="397" alt="image" src="https://github.com/user-attachments/assets/2f9f7777-f6a0-4273-a4b5-19f244b1c747" />







- **Main.kt** – Handles the menu and main logic  
- **models/** – Contains Kotlin classes representing entities:
  - `Person`, `Patient`, `Doctor`  
  - `Appointment`, `Prescription`, `Medicine`, `Bill`  

---



## **Features / Workflow**

### **1. Add Patients**
- Enter patient details: Name, Age, Contact, Patient ID
- Adds a patient to the system

### **2. Add Doctors**
- Enter doctor details: Name, Age, Contact, Doctor ID, Specialty
- Adds a doctor to the system

### **3. Patient Requests Appointment**
- Select patient  
- Choose doctor specialty  
- Select a doctor  
- Enter appointment ID and date/time  
- Creates an appointment request

### **4. Doctor Accepts Appointment & Prescribes**
- Select pending appointment  
- Doctor accepts appointment  
- Add medicines to prescription (Name, Stock, Price)  
- Enter patient condition/notes  
- Prescription is saved for the appointment

### **5. Patient Buys Medicines & Generates Bill**
- Select appointment  
- Enter purchased medicines (Name, Price)  
- Enter appointment fee  
- System calculates total:  
  `Total = Appointment Fee + Sum of Medicine Prices`  

### **6. Exit**
- Exit the program

---

## **How to Run**

1. **Install Kotlin Compiler**  

Check version:

```bash
kotlinc -version
sudo apt update
sudo apt install kotlin
```
Compile the project
```bash
cd /path/to/src
kotlinc Main.kt models/*.kt -include-runtime -d HospitalManagement.jar
```
Run the project
```bash
kotlin -classpath HospitalManagement.jar MainKt

```

## **Sample Menu**
===== Hospital Management System =====
1. Add Patient
2. Add Doctor
3. Patient Request Appointment
4. Doctor Accept & Prescribe
5. Patient Buy Medicines & Generate Bill
6. Exit
Choose an option:


## **Author**
## Sefat Ahmed
