(function(window) {
    'use strict';

    // Your starting point. Enjoy the ride!
    
    // 페이지를 로드한다
    $(document).ready(function(){
    	showTodo();
    });
    
    var newTodo = $('.new-todo'); // 입력 폼 
    var todoList = $('.todo-list'); // 할 일 리스트
    
    //footer 부분
    var all = $('#all');
    var active = $('#active');
    var completed= $('#completed');
    
    var count;
    var comcount = 0;
    var uncomcount = 0;
    
    // 할 일 등록 
    newTodo.keydown('click', function(key){
    	if(key.keyCode == 13) // 엔터 입력을 하면
    		{
    		if(newTodo.val() =="") // 공백일시
    			alert("할 일을 입력하세요 !");
    		else{
    			var todoData = {"todo":newTodo.val(), "completed":0, "date": new Date()};
    			$.ajax({
    				url: '/api/todos',
    				method: 'Post',
    				contentType: "application/json",
    				data: JSON.stringify(todoData),
    				success: function(data){
    					newTodo.val(''); // 빈 공백으로 만든다
    					showTodo(); // 새로고침없이 바로 데이터 로드
    				}
    			})
    		}
    	}
    });
    
    // 할 일 완료하기
    todoList.on("click", ".toggle", function(){
    	var id = $(this).attr("id");
    	var todo = $("#l" + id).text();
    	var todoData = {"todo":todo,"completed": 1, "date": new Date() };
    	console.log(id);
    	$.ajax({
            url: '/api/todos/'+ id,
            method: 'Put',
            contentType: "application/json",
            data: JSON.stringify(todoData),
            dataType: 'json',
            success: function(data) {
            	showTodo();
            }
    	});
    });
    
    // 할 일 삭제
    todoList.on("click", ".destroy", function(){
		var id = $(this).attr("id");
    	$.ajax({
            url: '/api/todos/' + id,
            method: 'Delete',
            contentType: "application/json",
            dataType: 'json',
            success: function(data) {
            	showTodo();
            }
    	});
    });

    all.click(function(){
    	 $('.filters > li > a.selected').removeClass();
         $('#all').addClass('selected');
         for (var i = 0; i < count; i++) {
             if (completed[i] == 0) {
                 $('#' + id[i]).show();
             } else {
                 $('#' + id[i]).show();
             }
         }
         $('.todo-count > strong').html(count);
     });
   
    active.click(function() {
    	showTodo();
        $('.filters > li > a.selected').removeClass();
        $('#active').addClass('selected');
        for (var i = 0; i < count; i++) {
            if (completed[i] == 0) {
                $('#' + id[i]).show();
            } else {
                $('#' + id[i]).hide();
            }
        }
        $('.todo-count > strong').html(comcount);
    })
    
    completed.click(function() {
        $('.filters > li > a.selected').removeClass();
        $('#completed').addClass('selected');
        for (var i = 0; i < count; i++) {
            if (completed[i] == 1) {
                $('#' + id[i]).show();
            } else {
                $('#' + id[i]).hide();
            }
        }
        $('.todo-count > strong').html(uncomcount);
    })


    
    
    function showTodo(){
		$.ajax({
			url: '/api/todos',
			method: 'GET',
			contentType: "application/json",
			dataType: 'json',
			success: function(data){
				todoList.empty();
                var count = data.length;
                var todo = [count];
                var id = [count];
                var completed = [count];
                
                // 객체에서 해당하는 할 일들을 뽑는다
                for (var i = 0; i < count; i++) {
                    todo[i] = data[i].todo;
                    completed[i] = data[i].completed;
                    id[i] = data[i].id;
                }
                // 최신 할 일이 앞에 보여진다
                for (var i = count - 1; i >= 0; i--) {
                    if (completed[i] == '0') {
                    	todoList.append(
                            '<li id="' + id[i] + '"><div class="view"><input id="' + id[i] +
                            '" class="toggle" type="checkbox"><label id="' + 'l' + id[i] + '" >' +
                            todo[i] +
                            '</label><button  id="' + id[i] + '" class="destroy"></button></div></li>'
                        );
                    } else if (completed[i] == '1') {
                    	todoList.append(
                            '<li id="' + id[i] + '" class="completed"><div class="view"><input id="' + id[i] +
                            '" class="toggle" type="checkbox" checked><label id="' + 'l' + id[i] + '" >' +
                            todo[i] +
                            '</label><button  id="' + id[i] + '"  class="destroy"></button></div></li>'
                        );
                    }
                }
		   }
		});
    }


    
})(window);