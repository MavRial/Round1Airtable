# Round1Airtable

Android app for the **Airtable Round 1 take-home assignment**.

---

## Summary

This project implements a **Timeline UI** in **Jetpack Compose** to display events across multiple days.  
Each event is represented in **swimlanes**, with support for **horizontal** and **vertical scrolling**.

---

## Features

- Events organized in **swimlanes** to avoid overlapping  
- `EventCard` composable for individual events  
- `DaysHeader` displaying dates on top of the timeline  
- **Horizontal and vertical** scrolling using `ScrollState`  
- Sample data (`SampleTimelineItems`) to demonstrate the timeline  
- **Clean and maintainable architecture** using Jetpack Compose and MVVM patterns  

---

## Project Structure

| File | Description |
|------|--------------|
| `models/Event.kt` | Defines the `Event` data class |
| `timeline/SampleTimelineItems.kt` | Contains sample events and lane assignment logic |
| `timeline/EventCard.kt` | Composable to render a single event card |
| `timeline/TimelineContent.kt` | Composable rendering events in lanes |
| `timeline/DaysHeader.kt` | Displays the days at the top of the timeline |
| `timeline/TimelineScreen.kt` | Main screen integrating all components |

---

## Screenshot

<img width="240" height="526" alt="image" src="https://github.com/user-attachments/assets/203d1ad6-1da0-44e8-883b-b412113fb44f" />


---

## ⚙️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Round1Airtable.git
