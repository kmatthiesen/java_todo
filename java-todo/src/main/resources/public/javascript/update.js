$(document).ready(function(){

  displayTasks();

  $('#task-update').submit(function(e){
    updateTask();
    e.preventDefault();
  });

  // When a new option is selected in the dropdown menu update the input fields.
  $('#task-update-list').change(function(){
    populateFields();
  });


});

// Populates the drop down menu with every TaskItem in the database.
function displayTasks(){
  $.ajax({
    url:'/tasks',
    method:'GET'
  }).then(
      function(tasks){
        for (var i=0; i<tasks.length; i++){
            $('#task-update-list').append('<option id="'+tasks[i].id+'">'+tasks[i].id+'. '+tasks[i].title+'</option>');
        }
      },
      function(error){
        JSON.stringify(error);
      }
    );
}

// Populates the input fields with the current values for the selected TaskItem.
function populateFields(){
  $.ajax({
    url:'/task/' + $('#task-update-list option:selected')[0].id,
    method:'GET'
  }).then(
      function(task){
        $('#task-update-title').val(task.title);
        $('#task-update-description').val(task.descrip);
        $('#task-update-user').val(task.owner);
        $('#task-update-status').val(task.status);
      },
      function(error){
        JSON.stringify(error);
      }
    );
}

// Creates a new task item and sends it to the java cod using ajax.
function updateTask(){
  var task = {};
  task.id = $('#task-update-list option:selected')[0].id;
  task.title = $('#task-update-title').val();
  task.descrip = $('#task-update-description').val();
  task.status = $('#task-update-status option:selected').val();
  task.owner = $('#task-update-user').val();

  $.ajax({
    url:'/task/'+ $('#task-update-list option:selected')[0].id,
    method: 'PUT',
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
