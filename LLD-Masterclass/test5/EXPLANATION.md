# Test 5: Adapter Design Pattern (Structural)

## 🔌 1. What is the Adapter Pattern? (Simple Explanation)
Imagine you have a **US Laptop Plug** (Flat pins) but you are in **India** (Round sockets). You don't buy a new laptop! You buy a small $1 **Adapter**. 
The Adapter Pattern allows two incompatible interfaces to work together by acting as a translator.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Old Interface (`MediaPlayer.java`)
- Your old app only knows how to play `mp3`. This is the standard interface.

### Step 2: The New Interface (`AdvancedMediaPlayer.java`)
- You found a library that plays `vlc` and `mp4`, but it has different method names. They are incompatible!

### Step 3: The Translator (`MediaAdapter.java`)
- This is the **Magic Class**. 
- It implements the *Old* interface but holds an instance of the *New* interface.
- When you call `play()`, it translates that call into `playVlc()` or `playMp4()`.

### Step 4: The Consumer (`AudioPlayer.java`)
- This class now has "Superpowers." It can play its own `mp3` AND it can use the `MediaAdapter` to play new formats.

---

## 🚀 3. Real World Use Cases
1. **Arrays.asList()**: Adapts an Array into a List.
2. **InputStreamReader**: Adapts a Byte stream into a Character stream.
3. **Legacy Integration**: When your new Spring Boot app needs to talk to a 20-year-old COBOL system.

## ⚠️ 4. Senior Tip: Adapter vs Proxy
- **Adapter**: Changes the interface so client can use it.
- **Proxy**: Keeps the SAME interface but adds security or logging.
