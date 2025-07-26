# 💬 CometChat UI Kit Integration – Kotlin (Android)

This project is a basic integration of the CometChat UI Kit using Kotlin (Android) as part of the CometChat Internship Task. The app showcases a functional **Conversation List** and **Message View**, following CometChat v5 SDK documentation.

---

## 📱 Features Implemented

- ✅ CometChat v5 UI Kit (Kotlin SDK)
- ✅ Group conversation listing
- ✅ One-to-one & group message screen
- ✅ Navigation from conversations to message view

---

## 🧑‍💻 Tech Stack

- **Language:** Kotlin  
- **UI Framework:** Android Views  

---

## 🔐 Credentials & Security

All credentials are stored securely in `local.properties` and **not committed** to version control.

```properties
COMETCHAT_APP_ID=your-app-id
COMETCHAT_REGION=your-region
COMETCHAT_AUTH_KEY=your-auth-key
```
Build and run the project in Android Studio.

---

🐞 Issue Faced
Problem:
While following the documentation for CometChat UI Kit v5, the method setOnItemClick() was mentioned for handling conversation clicks. However, this method was not available in the Kotlin.

✅ Resolution
Instead of using setOnItemClick(), it was showing a property called onItemClick, which can be assigned a listener object.

Here’s the working code that resolved the issue:

```
conversationView.onItemClick = object : OnItemClick<Conversation> {
    override fun click(p0: View?, p1: Int, p2: Conversation?) {
        if (p2 != null) {
            startMessageActivity(p2)
        }
    }
}
```

🔍 Why onItemClick Worked
Unlike older SDKs (or Java-based versions) that used methods like setOnItemClick(), the CometChat Kotlin SDK v5 follows Kotlin-first design.

It exposes onItemClick as a public mutable property rather than a setter method. This is a more idiomatic Kotlin approach and allows assignment using:

```
conversationView.onItemClick = ...
This eliminates the need for a setOnItemClick() method and aligns with modern Android development practices.
```

---

📸 Screenshots
<table>
  <tr>
    <td align="center">
      <strong>Conversation List</strong><br/>
      <img width="250" height="600" alt="Conversation List" src="https://github.com/user-attachments/assets/fe6b38a4-0367-4444-8664-bcdb2efafee5" />
    </td>
    <td align="center">
      <strong>Message View</strong><br/>
      <img width="250" height="600" alt="Message View" src="https://github.com/user-attachments/assets/96113840-4731-4de9-8e4b-50493693341c" />
    </td>
  </tr>
</table>

