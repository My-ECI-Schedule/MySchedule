var kanbanApi = (function(){

    var kanbanData;
    var cont = 1;

    function getCont(){
        return cont;
    }

    function sumCont(){
        cont += 1;
    }

    function getData(){
        $.ajax({
            type:"GET",
            url: "/api/kanban/getById?id="+sessionStorage.getItem("kanban")
        }).then(function (data) {
            data.forEach(column => {
                createColumn(column);
                $.ajax({
                    type:"GET",
                    url:"/api/task/getByColumn?id="+column.id
                }).then( function(tasks){
                    tasks.forEach(task=>{
                        createItem(task);
                    });
                });
            });
            eliminarColumn();
            kanban.loadlisteners();
        });
    }

    function createItemJson(task){
        console.log(task);
        var newItem = parseHtml("<div id=\"item"+cont+"\" class=\"kanban-item\">"
                +"<div id=\"t"+cont+"\" class=\"item-input\" draggable=\"" +task.ipublic+ "\" columnId=\""+task.idcolumn+"\" taskId=\""+task.idtask+"\">"+task.description+"</div>"
                +"<div class=\"dropzone\"></div>"
                +"</div>");
                var nameColunm = document.querySelector('[columnId=\"' + task.idcolumn+ '\"]').getAttribute("id");
                $("#"+nameColunm).append(newItem);
                cont += 1;
    }

    function createColumn(column){
        var newItem = parseHtml("<div id=\"column"+column.id+"\" class=\"kanban-column\">"
                +"<div class=\"column-title\">"+column.name+"</div><div id=\""+column.name+"\" class=\"items\" columnId=\""+column.id+"\" > <div class=\"dropzone\"></div>" 
                +"</div>"
                +"<button class=\"add-item\" type=\"button\">+</button></div>");
        document.getElementById("kanban").appendChild(newItem);
    }

    function eliminarColumn(){
        var newItem = parseHtml("<div id=\"column-1\" class=\"kanban-column\">"
                +"<div class=\"column-title\">Eliminar</div><div id=\"eliminar\" class=\"items\"> <div class=\"delete-dropzone\">🗑️</div>" 
                +"</div>"
                +"</div>");
        document.getElementById("kanban").appendChild(newItem);
    }

    function createItem(task){
        var newItem = parseHtml("<div id=\"item"+cont+"\" class=\"kanban-item\">"
                +"<div id=\"t"+cont+"\" class=\"item-input\" draggable=\"" +task.public+ "\" columnId=\""+task.idKanbanColumn.id+"\" taskId=\""+task.id+"\">"+task.description+"</div>"
                +"<div class=\"dropzone\"></div>"
                +"</div>");
                $("#"+task.idKanbanColumn.name).append(newItem);
                cont += 1;
    }

    function parseHtml(html){
        var t = document.createElement('template');
        t.innerHTML = html;
        return t.content;
    }

    return {
        getKanban : getData,
        getTaskCont: getCont,
        sumToCont: sumCont,
        create: createItemJson
    }
})();