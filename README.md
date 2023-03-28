![header](https://eckner.it/oth_zapp_header.jpg "oth_zapp_header.jpg")

### **Übungen zum Fach ZAPP**

#### **1. Activities und Layouts**

> Ziel der Übung ist es einen Einblick in die Entwicklung von Android-Oberflächen zu erlangen und dabei die Definition von UI-Elementen in XML und deren Referenzierung in Kotlin Programmcode zu verwenden.

#### 1.1 Hello World

Legen Sie zuerst ein neues Projekt (`File -> New -> New Project...` bzw. auf der Android Studio Startseite `New Project`) an. Auf der ersten Seite können bereits einige Activity Templates ausgewählt werden - aus Verständnisgründen starten Sie aber ohne Boilerplate Code. Wählen Sie daher die Option `No Activity` im Reiter `Phone and Tablet` aus.  
Im nächsten Schritt können Sie einen beliebigen App Namen und eine Company Domain angeben. Als `Minimum SDK` empfielt sich aufgrund der Kompatibilität eine Version welche auf vorhandenen Smartphones läuft. Als Programmiersprache ist `Kotlin` auszuwählen.  
Nach einer kurzen Gradle Build Phase sollten Sie in der Ansicht _Project_  _(View -> Tool Windows -> Project)_ ein Modul `app` sehen, welches sich in die drei “Pakete” `manifests`, `java` und `res` unterteilt.  
Klappen Sie das `java` Paket auf und legen Sie mittels Rechtsklick auf den Paketnamen eine neue Activity an (`New -> Activity -> Empty Activity`). Im daraufhin aufgehenden Fenster können Sie noch den Namen der Kotlin Klasse sowie des XML files, in welchem wir gleich das Layout definieren werden, festlegen. Wählen Sie zusätzlich auch die Option `Launcher Activity` an und klicken Sie auf `Finish`.

Folgendes sollte Ihnen in der Projekt-Ansicht auffallen:

1. Im Java Verzeichnis hat Android Studio eine Klasse angelegt welche von  `AppCompatActivity`  ableitet und bereits eine Methode der Super-Klasse namens  `#onCreate(Bundle?)`überschreibt. Hier legen wir fest welches XML file inflated respektive angezeigt werden soll. Dies geschieht mittels der  `setContentView(View)`  Methode.

2. Im `res- > layout` Verzeichnis ist eine XML-Datei hinzugekommen, in welcher bereits das Layout für unsere Activity spezifiziert ist. Aktuell ist dieses noch ohne Inhalt.

3. Im Manifests Verzeichnis, näher in der `AndroidManifest.xml` Datei, hat Android Studio die neue Activity bereits deklariert und einen `<intent-filters>` hinzugefügt. Dieser signalisiert dem System, welche Activity zum Einstieg verwendet werden soll, sobald diese über den App Drawer gestartet wird.  
   **Wichtig:** Jede Activity einer App muss im Manifest deklariert werden.

Nehmen Sie folgende Änderungen vor:

- Öffnen Sie die XML-Datei Ihrer Einstiegs-Activity und ändern Sie das root-layout von  `ConstraintLayout`  zu  `LinearLayout`. Fügen Sie innerhalb des  `<LinearLayout ...>` tags folgendes Attribut hinzu:  `android:orientation="vertical"`
- Fügen Sie einen Button hinzu und geben Sie diesem einen Text (`android:text`) und eine Id (`android:id`).

Zum Hinzufügen verwenden Sie entweder den Layout Editor oder direkt die XML-Datei. Es empfiehlt sich die XML-Variante, da hierbei der Lerneffekt größer ist.

Das Resultat könnte in etwa so aussehen:

```xml
<LinearLayout ... >

    <Button
        android:id="@+id/hello_world_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Say 'Hello World!'" />

</LinearLayout>

```

Um den Button benutzen zu können, muss hierfür in der Activity eine Referenz auf diesen erzeugt werden. Dies geschieht mittels der `findViewById(...)` Methode. Im Anschluss daran wird dem Button ein `OnClickListener` gegeben um beim Klick darauf eine Aktion ausführen zu können.

```kotlin
val button : Button = findViewById(R.id.hello_world_button)

button.setOnClickListener(object : View.OnClickListener {
    override fun onClick (v: View?) {
        Log.d("TAG", "Hello World!")
    }
})

```

#### 1.2 Intents

Fügen Sie ein  `EditText`  Feld zum Layout hinzu und legen Sie einen Hilfstext (`android:hint`) sowie eine Id (`android:id`) fest.

```xml
<EditText
    android:id="@+id/activity_main_edit_text"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Enter something" />
```

Legen Sie nun eine weitere Activity an und rufen Sie diese, nach dem Klick auf den Button in der ersten Activity auf. Zum starten einer weiteren Activity müssen wir zuerst einen `Intent` erstellen und im Anschluss `startActivity` aufrufen. Als erster Paramete wird der Context benötigt, im unterem Fall die aufrufende Activity. Die aufzurufende Activity wird als zweiter Parameter mitgegeben.

```kotlin
val intent = Intent(this, SecondActivity::class.java)
startActivity(intent)
```

Zusätzlich möchten wir auch den eingegebenen Text aus dem `EditText` an unsere zweite Activity übertragen (`EditText#getText()`. Zur Übergabe von Werten an die Ziel-Activity können wir die Methode `Intent#putExtra(name, value)` verwenden. In der aufgerufenen Activity kommen wir an diese Werte wieder mittels `intent.getStringExtra(name)`.
**Hinweis:** Übergeben werden können nur primitive Datentypen oder solche die das `Serializable` oder `Parcelable` interface implementieren.

Führen Sie die entsprechenden Schritte durch und zeigen Sie den eingegebenen Text in der zweiten Activity, zum Beispiel innerhalb einer `TextView` an.

**Tipp:** Referenz auf den EditText erzeugen, Text beim Button Click herausziehen und dem erzeugten Intent mitgeben.
