package marko.androidapp.letsdoit.Model;

public class Task
{
    private String name;
    private String description;
    private String dateItemAdded;
    private String DoDate;
    private int id;

    public Task()
    {

    }

    public Task(String name, String description, String dateItemAdded, String doDate, int id)
    {
        this.name = name;
        this.description = description;
        this.dateItemAdded = dateItemAdded;
        this.DoDate = doDate;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateItemAdded() {
        return dateItemAdded;
    }

    public void setDateItemAdded(String dateItemAdded) {
        this.dateItemAdded = dateItemAdded;
    }

    public String getDoDate() {
        return DoDate;
    }

    public void setDoDate(String doDate) {
        DoDate = doDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
