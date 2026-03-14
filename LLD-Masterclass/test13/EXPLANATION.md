# Test 13: Bridge Design Pattern (Structural)

## 🌉 1. What is the Bridge Pattern? (Simple Explanation)
Imagine you have **2 Types of Remotes** (Basic and Advanced) and **2 Types of Devices** (TV and Radio).
- Without Bridge: You would need 4 classes: `BasicTVRemote`, `AdvancedTVRemote`, `BasicRadioRemote`, `AdvancedRadioRemote`.
- If you add a "Super Remote," you need 2 more. If you add a "Fridge," you need 3 more!
The Bridge pattern **Separates** the "Remote" (Switch) from the "Device" (Action) so they can grow independently.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Implementation (`Device.java`)
- This is the low-level logic. Every device (TV, Radio) must know how to turn on/off and change volume.

### Step 2: The Abstraction (`Remote.java`)
- This is the "User Interface." The remote has a reference to a `Device` (The Bridge!).
- When you press `togglePower()` on the remote, it just tells the device to `enable()` or `disable()`.

### Step 3: Refined Abstraction (`AdvancedRemote.java`)
- You can create a new remote with a `mute()` button **without touching the TV or Radio code!**

### Step 4: The Result (`BridgeDemo.java`)
- You can plug any remote into any device. 
- You linked them using the "Bridge" (the reference inside the remote).

---

## 🚀 3. Why use this?
1. **Avoid Class Explosion**: It changes a "Multiply" problem ($M \times N$ classes) into an "Add" problem ($M + N$ classes).
2. **Platform Independence**: Your app (The Abstraction) can work on different Databases or OS types (The Implementation) without knowing the details.

## ⚠️ 4. Senior Tip: Composition over Inheritance
Bridge is a classic example of "Composition over Inheritance." Instead of inheriting behavior from the TV, the Remote **has a** TV and talks to it through an interface.
