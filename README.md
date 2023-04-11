![header](https://eckner.it/oth_zapp_header.jpg "oth_zapp_header.jpg")

### **Übungen zum Fach ZAPP**

#### **2. RecyclerView**

#### 2.1 Basics

> Eine der wichtigsten Komponenten einer jeden App sind Listen, welche eine dynamische Anzahl von Einträgen darstellen können. Unter Android verwenden Sie dazu im Rahmen dieser Übung die sogenannte `RecyclerView`.
>
> Ziele der Übung:  
> \- Anlegen eines RecyclerView-Adapters zur Anzeige von Listeneinträgen.  
> \- Recycling  einzelner Zeilen der RecyclerView und Erhalt deren Status.

### Aufgaben

*Legen Sie ein neues Projekt an. Als Template können Sie `Empty Activity` auswählen; dadurch wird automatisch die Einstiegs-Activity samt Layout generiert. Alternativ nutzen Sie das zur Verfügung stehende Boilerplate-Projekt aus GitHub.*

1. Fügen Sie folgende Zeile in das `build.gradle` file des app modules hinzu. Diese ermöglicht die Verwendung der RecyclerView und lädt entsprechende Komponenten nach.

   > implementation 'androidx.recyclerview:recyclerview:1.3.0'

2. Legen Sie ein neues Layout an oder verwenden Sie ein vorhandenes und fügen Sie das Layout Element für die `RecyclerView` hinzu

    ```xml
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
    ```

3. Erstellen Sie nun zusätzlich noch ein Layout für die Zeile der RecyclerView, welche zur Anzeige der unterschiedlichen Einträge genutzt wird. Das neue Layout erstellen Sie mittels `res -> layout -> Rechtsklick -> New -> Android Resource File`. Es soll aus einer `CheckBox` bestehen. Achten Sie darauf, dass das Root-Layout Element als Höhe `wrap_content` hat.
4. Als nächstes legen Sie den Adapter für die RecyclerView als eigene Klasse an. Verwenden Sie dazu folgenden Boilerplate Code und lösen Sie die TODOs

```kotlin
class ItemAdapter(private val data: List<String>): 
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

        // TODO: Get a reference to the checkbox with view.findById(...)
        val itemCheckBox: CheckBox = ...
    }

    override fun onCreateViewHolder(parent: ViewGroup, 
            viewType: Int): ItemViewHolder {

        // TODO: Use the LayoutInflater with the parent ViewGroup to inflate the layout for one individual row item
        val adapterLayout = LayoutInflater.from(parent.context).inflate(..., ..., false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        // TODO: Return size of data set instead of 0
        return 0
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        // TODO: Set text of one individual checkbox with help of given parameters
        val itemString = ...
        ... = itemString
    }
}
```

Nun müssen Sie nur noch den Adapter mit der RecyclerView verbinden. Erzeugen Sie eine Referenz auf die RecyclerView und fügen Sie folgende Zeilen in Ihre MainActivity ein:

```kotlin
val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
recyclerView.layoutManager = LinearLayoutManager(this)
recyclerView.adapter = ListAdapter(randomValues)
```

**Erklärung:** Die `RecyclerView` benötigt einen `LayoutManager` zum darstellen der Items. Die Einträge sollen untereinander dargestellt werden, daher wird ein `LinearLayoutManager` verwendet und dieser für die RecyclerView gesetzt.

Damit die RecyclerView überhaupt etwas anzeigt, wird ein entsprechender Datensatz benötigt. Dieser wird an die Adapterklasse übergeben. Legen Sie eine Liste bestehend aus mehreren Strings an und übergeben Sie diese der RecyclerView. Sie können auch nachfolgendes Code-Fragment verwenden um eine Liste von 50 Elementen zu generieren:

```kotlin
private val randomValues =
    List(50) {('A' + Random.nextInt('Z' - 'A')).toString() + " " + it.toString()}
```

Führen Sie das Projekt aus: Ihre RecyclerView zeigt nun Einträge in einer Listenansicht an.

#### 2.2 Interaktion und Optimierung

Nun soll bei einem Klick auf eine Zeile der RecyclerView deren Position in der Liste angezeigt werden. Geben Sie dazu Ihrer `CheckBox` in der init-Methode des `ViewHolder`s einen `OnClickListener` und geben Sie die Position mittels eines Toasts aus - zum Beispiel mittels:

```kotlin
Toast.makeText(
        view.context,
        String.format(
                Locale.GERMAN,
                "Position: %d; is checked: %s",
                layoutPosition,
                itemCheckBox.isChecked
        ),
        Toast.LENGTH_SHORT
).show()
```

**Info zum Toast:**

- Der erste Parameter ist der Kontext auf dem die Nachricht ausgegeben werden soll.
- Der zweite Parameter ist der auszugebende Text.
- Der dritte Parameter ist die Dauer der Anzeige des Textes. (`Toast.LENGTH_LONG` bzw. `Toast.LENGTH_SHORT`)

Wenn Sie nun die erste Zeile selektieren und weiter herunterscrollen, werden Sie feststellen, dass auch weitere Zeilen angewählt sind. Das liegt daran, dass die RecyclerView, wie der Name schon impliziert, die einzelnen Zeilen wiederverwendet. Folglich müssen Sie sich die angewählten Positionen merken und jedes Mal wenn `onBindViewHolder` aufgerufen wird, die CheckBox entsprechend an- oder abwählen.  
Überlegen Sie sich eine Lösung und implementieren Sie diese zur Bewältigung des Problems.

**Tipp:** Ein [SparseBooleanArray](https://developer.android.com/reference/kotlin/android/util/SparseBooleanArray) könnte hilfreich sein. Den Zustand können Sie mittels des Attributs `CheckBox#isChecked` festlegen.
