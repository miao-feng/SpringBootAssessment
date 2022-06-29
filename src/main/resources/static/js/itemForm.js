const taskControl = new ItemController();

newItemForm.addEventListener("submit", (event) => {
  event.preventDefault();

  let title = document.querySelector("#newItemNameInput").value;
  let description = document.querySelector("#newItemDescription").value;
  let date = document.querySelector("#newItemDate").value;

  taskControl.addItem(title, description, date);

  title = "";
  description = "";
  date = "";
});
