# 📖 LugatApp

**LugatApp** — Android uchun yozilgan ingliz-o'zbek lug'at (dictionary) ilovasi. Ilova so'zlarni tezkor qidirish, ularning talaffuzini (Text-to-Speech) tinglash va tarjimalarini ko'rish imkonini beradi.

## ✨ Xususiyatlari

- 🔍 **Tezkor qidiruv** — so'zlarni real vaqtda qidirish, mos kelgan qism ro'yxatda ranglar bilan ajratib ko'rsatiladi
- 🔊 **Talaffuz (Text-to-Speech)** — har bir so'zning ingliz tilidagi talaffuzini eshitish
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
| **Navigation Component** | Fragmentlar orasida navigatsiya |
| **Android TextToSpeech API** | So'zlarning talaffuzini ovoz orqali chiqarish |
| **KSP** | Room annotatsiyalarini kompilyatsiya qilish |

## 📂 Loyiha tuzilmasi

```
app/src/main/java/com/abdullojon/lugatapp/
├── MainActivity.kt              # Ilovaning asosiy activity'si
├── app/
│   └── Myapp.kt                 # Application klassi, DB ni initsializatsiya qiladi
├── adapter/
│   ├── DictionaryAdapter.kt     # RecyclerView adapteri
│   └── BaseUtils.kt             # Qidiruv natijalarini ranglash uchun extension funksiyalar
├── data/
│   ├── Dictionary.kt            # Room Entity (so'z modeli)
│   ├── DictionaryDao.kt         # Ma'lumotlar bazasi so'rovlari (DAO)
│   └── MyDatabase.kt            # Room Database klassi
└── fragments/
    └── MainFragment.kt          # Qidiruv va ro'yxatni ko'rsatish logikasi

app/src/main/assets/database/
└── dictionary.db                # Oldindan to'ldirilgan lug'at bazasi
```

## 🚀 O'rnatish va ishga tushirish

### Talablar

- [Android Studio](https://developer.android.com/studio) (so'nggi versiya tavsiya etiladi)
- JDK 11+
- Android SDK (`minSdk 24`, `targetSdk 36`, `compileSdk 37`)

### Qadamlar

1. Repozitoriyni klonlang:
   ```bash
   git clone https://github.com/<username>/lugatapp.git
   ```
2. Loyihani Android Studio orqali oching.
3. Gradle sinxronizatsiyasi avtomatik boshlanishini kuting.
4. Qurilma yoki emulyatorni tanlab, ▶️ **Run** tugmasini bosing.

Shuningdek, terminal orqali ham qurish mumkin:

```bash
./gradlew assembleDebug
```

APK fayl quyidagi manzilda paydo bo'ladi:
```
app/build/outputs/apk/debug/app-debug.apk
```

## 📱 Foydalanish

1. Ilovani oching — lug'atdagi barcha so'zlar ro'yxati avtomatik yuklanadi.
2. Qidiruv maydoniga so'z (masalan, inglizcha) kiriting — natijalar real vaqtda filtrlanadi.
3. Har bir so'z yonidagi 🔊 tugmani bosib, uning ingliz tilidagi talaffuzini tinglang.

## 🗄️ Ma'lumotlar bazasi

Lug'at bazasi `dictionary` jadvalidan iborat bo'lib, quyidagi maydonlarni o'z ichiga oladi:

| Maydon | Tavsifi |
|---|---|
| `id` | Noyob identifikator |
| `english` | Inglizcha so'z |
| `type` | So'z turi (noun, verb va h.k.) |
| `transcript` | Talaffuz transkripsiyasi |
| `uzbek` | O'zbekcha tarjimasi |
| `countable` | Sanaladigan/sanalmaydiganligi |
| `is_favourite` | Sevimlilar belgisi |

Baza `app/src/main/assets/database/dictionary.db` sifatida saqlanadi va ilova birinchi marta ishga tushganda Room orqali avtomatik yuklanadi.

## 🤝 Hissa qo'shish

Pull request va takliflarni mamnuniyat bilan qabul qilamiz:

1. Repozitoriyni fork qiling
2. Yangi branch yarating (`git checkout -b feature/yangi-funksiya`)
3. O'zgarishlaringizni commit qiling (`git commit -m "Yangi funksiya qo'shildi"`)
4. Branchni push qiling (`git push origin feature/yangi-funksiya`)
5. Pull Request oching

## 👤 Muallif

**Abdullojon** 
