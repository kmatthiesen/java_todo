$(document).ready(function(){
  $('#filter-btn').on('click', function(){
    filter();
  });

  $('#reset-btn').on('click', function(){
    $('#error-table').empty();
    sortId();
  });

  sortId();


});

// Sends the value to filter the table by and which type of filter using ajax to the java code.
function filter(){
  $('#error-table').empty();
  if (validateFilter()){
    $.ajax({
      url:'/tasks/filter/'+  $('#home-filter option:selected').val() + '/' + $('#filter-input').val(),
      method:'GET'
    }).then(
      function(tasks){
        populateList(tasks);
        assignClick();
        $('#filter-input').val("");
      },
      function(error){
        console.log(JSON.stringify(error));
      }
    );
  }
  else {
    $('#error-table').append("Invalid Filter");
  }
}

// Validates the filter input and returns if it was a match.
function validateFilter(){
  var filterInput = $('#filter-input').val();
  if ($('#home-filter option:selected').val() == "status"){
    if (filterInput.toUpperCase() == "COMPLETE" || filterInput.toUpperCase() == "INCOMPELTE" || filterInput.toUpperCase() == "IN-PROGRESS"){
      return true;
    }
  }
  else if ($('#home-filter option:selected').val() == "owner") {
    var pattern = /^[0-9a-zA-Z]{1,20}$/;
    var match = pattern.test($('#filter-input').val());
    return match;
  }
  else if ($('#home-filter option:selected').val() == "title") {
    var pattern = /^[0-9a-zA-Z]{1,20}$/;
    var match = pattern.test($('#filter-input').val());
    return match;
  }
}

// Assigns click events to each table header.
function assignClick(){
  $('#table-title').on('click', function(){
    sortTitle();
  });
  $('#table-id').on('click', function(){
    sortId();
  });
  $('#table-user').on('click', function(){
    sortUser();
  });
  $('#table-status').on('click', function(){
    sortStatus();
  });
}

// Sends a request to the java code for a task list sorted by id.
function sortId(){
  $.ajax({
    url:'/tasks',
    method:'GET'
  }).then(
    function(tasks){
      populateList(tasks);
      assignClick();
    },
    function(error){
      console.log(JSON.stringify(error));
    }
  );

}

// Sends a request to the java code for a task list sorted by title.
function sortTitle(){
  $.ajax({
    url:'/tasks/title',
    method:'GET'
  }).then(
    function(tasks){
      populateList(tasks);
      assignClick();
    },
    function(error){
      console.log(JSON.stringify(error));
    }
  );

}

// Sends a request to the java code for a task list sorted by user.
function sortUser(){
  $.ajax({
    url:'/tasks/user',
    method:'GET'
  }).then(
    function(tasks){
      populateList(tasks);
      assignClick();
    },
    function(error){
      console.log(JSON.stringify(error));
    }
  );

}

// Sends a request to the java code for a task list sorted by status.
function sortStatus(){
  $.ajax({
    url:'/tasks/status',
    method:'GET'
  }).then(
    function(tasks){
      populateList(tasks);
      assignClick();
    },
    function(error){
      console.log(JSON.stringify(error));
    }
  );

}

// Empties out the out table data and then appends a header row and then every TaskItem from the database.
function populateList(tasks){
  $('#view-task-list').empty();
  $('#view-task-list').append(
    '<tr id="table-header"><td id="table-id">Task ID</td><td id="table-title">Title</td><td id="table-desctription">Description</td><td id="table-user">Assigned User</td><td id="table-status">Status</td></tr>'
  );
  for (var i=0; i<tasks.length; i++){
      $('#view-task-list').append(
        '<tr><td>' + tasks[i].id + '</td><td>' + tasks[i].title + '</td><td>' + tasks[i].descrip + '</td><td>' + tasks[i].owner + '</td><td id="task-status">' + tasks[i].status + '</td></tr>'
      );
    }
}
