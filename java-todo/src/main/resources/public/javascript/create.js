$(document).ready(function(){

  $('#task-create').submit(function(e){
    createTask();
    e.preventDefault();
  });

});

// Create a new task by grabbing the value of each input field and assigning them to a task object that mirrors a TaskItem in the java code.
// The sends the new task using ajax.
function createTask(){

  var task = {};
  task.title = $('#task-create-title').val();
  task.descrip = $('#task-create-description').val();
  task.status = $('#task-create-status option:selected').val();
  task.owner = $('#task-create-user').val();

  console.log(task);


  $.ajax({
    url:'/task',
    method: 'POST',
    contentType: 'application/json',
    data: JSON.stringify(task)
  }).then(
    function(task){
      window.location.href="/";
    },
    function(error){
      console.log(JSON.stringify(error));
    }
  );

}
