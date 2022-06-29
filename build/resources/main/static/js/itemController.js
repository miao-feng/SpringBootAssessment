const createTaskItem = (title, description, date) =>
  ` <tr>
   
    <td>${title}</td>
    <td>${description}</td>
    <td>${date}</td>
    </tr>
    `;

class ItemController {
  constructor() {
    this.items = [];
  }

  addItem(title, description, date) {
    let itemController = this;
    const formData = new FormData();
    formData.append("title", title);
    formData.append("description", description);
    formData.append("date", date);

    fetch("http://localhost:8080/item/add", {
      method: "POST",
      body: formData,
    })
      .then(function (response) {
        console.log(response.status);
        if (response.ok) {
          alert("Successfully Added Task!");
        } else {
          throw Error(response.statusText);
        }
      })
      .catch((error) => {
        console.error("Error:", error);
        alert("Error adding task");
      });
  }

  displayTask() {
    let itemController = this;
    itemController.items = [];

    fetch("http://localhost:8080/item/all")
      .then((resp) => resp.json())
      .then(function (data) {
        console.log(data);
        data.forEach(function (item, index) {
          const itemObj = {
            id: item.id,
            title: item.title,
            description: item.description,
            date: item.date,
          };
          itemController.items.push(itemObj);
        });

        itemController.renderTaskList();
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  renderTaskList() {
    let taskList = [];

    for (let i = 0; i < this.items.length; i++) {
      const item = this.items[i];
      const task = createTaskItem(item.title, item.description, item.date);

      taskList.push(task);
    }

    const taskDisplay = taskList.join("\n");
    document.querySelector("#taskrow").innerHTML = taskDisplay;
  }
}
