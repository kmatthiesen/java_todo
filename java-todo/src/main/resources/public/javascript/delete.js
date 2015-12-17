$(document).ready(function(){
  displayTasks();

  $('#task-delete').submit(function(e){
    deleteTask();
    e.preventDefault();
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
            $('#task-delete-list').append('<option id="'+tasks[i].id+'">'+tasks[i].id+'. '+tasks[i].title+'</option>');
        }
      },
      function(error){
        JSON.stringify(error);
      }
    );
}

// Retrieves the id of the item to be deleted from the selected drop down menu option and sends it using ajax to the java code.
function deleteTask(){

  $.ajax({
    url:'/task/'+ $('#task-delete-list option:selected')[0].id,
    method: 'DELETE'
  }).then(
    function(task){
      window.location.href="/";
    },
    function(error){
      console.log(JSON.stringify(error));
    }
  );

}
