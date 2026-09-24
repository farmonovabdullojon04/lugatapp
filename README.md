# 📖 LugatApp

**LugatApp** — Android uchun yozilgan ingliz-o'zbek lug'at (dictionary) ilovasi. Ilova so'zlarni tezkor qidirish, ularning talaffuzini (Text-to-Speech) tinglash, tarjimalarini ko'rish va sevimli so'zlarni saqlab qo'yish imkonini beradi.

## ✨ Xususiyatlari

- 🔍 **Tezkor qidiruv** — so'zlarni real vaqtda qidirish, mos kelgan qism ro'yxatda ranglar bilan ajratib ko'rsatiladi
- 🔊 **Talaffuz (Text-to-Speech)** — har bir so'zning ingliz tilidagi talaffuzini eshitish
- ⭐ **Saqlanganlar (Bookmark)** — yoqqan so'zlarni "Saqlanganlar" bo'limiga qo'shish, ular orasida ham qidirish va istalgan vaqtda olib tashlash
- 📄 **Batafsil ma'lumot** — har bir so'z uchun turkumi (part of speech), transkripsiyasi, sanalishi (countable/uncountable) va tarjimasi bilan alohida sahifa
- 📋 **Nusxalash va ulashish** — so'zni, uning ma'nosini yoki to'liq ma'lumotni bufferga nusxalash hamda boshqa ilovalarga ulashish
- 🧭 **Bottom Navigation** — "Lug'at" va "Saqlanganlar" bo'limlari orasida qulay o'tish
- 📚 **Tayyor lug'at bazasi** — ilova ichiga oldindan to'ldirilgan SQLite (Room) ma'lumotlar bazasi bilan birga keladi
- 📱 **Zamonaviy interfeys** — Material Design va Edge-to-Edge dizayn
- 🌙 **Kecha rejimi** — tungi (dark) mavzu qo'llab-quvvatlanadi

## 🛠️ Texnologiyalar

| Texnologiya | Vazifasi |
|---|---|
| **Kotlin** | Asosiy dasturlash tili |
| **Room** | Lokal ma'lumotlar bazasi (SQLite) bilan ishlash |
| **View Binding** | View elementlariga xavfsiz murojaat qilish |
| **RecyclerView** | So'zlar ro'yxatini chiqarish |
| **Navigation Component** | Fragmentlar (Lug'at, Saqlanganlar, Tafsilot) orasida navigatsiya |
| **BottomNavigationView** | Bo'limlar orasida asosiy navigatsiya |
| **Android TextToSpeech API** | So'zlarning talaffuzini ovoz orqali chiqarish |
| **KSP** | Room annotatsiyalarini kompilyatsiya qilish |

## 📂 Loyiha tuzilishi

```
app/src/main/java/com/abdullojon/lugatapp/
├── app/          → Application klassi
├── adapter/      → RecyclerView adapteri va yordamchi util funksiyalar
├── data/         → Room entity (Dictionary), DAO va Database
└── fragments/    → MainFragment, SavedFragment, DetailFragment
```

<img width="360" height="780" alt="image" src="https://github.com/user-attachments/assets/0c063eee-8a7e-40e6-a454-f1d82e8f74b6" />
<img width="360" height="780" alt="image" src="https://github.com/user-attachments/assets/ca70d396-2203-445c-ad23-05482e763e3b" />
<img width="360" height="780" alt="image" src="https://github.com/user-attachments/assets/13c4cf60-4f04-47a7-a241-cc58c6eecebb" />
<img width="360" height="780" alt="image" src="https://github.com/user-attachments/assets/21abe45f-d476-486a-9d7f-0667989f33d6" />

## 👤 Muallif

**Abdullojon Farmonov**

**farmonovabdullojon04@gmail.com**
