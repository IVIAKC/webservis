/**
 * Created by IVIAKC on 06.11.2015.
 */
    function addLi(text){
        var str_creat = document.createElement('li');
        var sec_in;
        sec_in = document.getElementById('ol_id');
        sec_in.appendChild(str_creat);
        str_creat.innerHTML = text;
    }

function tab_load(){
    var ajax = new XMLHttpRequest();
    ajax.open('GET','http://smart-route.ru:8100/adapter-web/rest/dictionary/c580d006-f86f-4bdd-84be-b51de6f626c6',false);
    ajax.send();

    var response = ajax.responseText;
    text = JSON.parse(response);
    text_doc = text.documents;
    var tab = document.getElementById('table_in');
    var j=1;
    text_doc.forEach(function(item){
        var tr = document.createElement('tr');
        tab.appendChild(tr);
        for(var i=0;i<5;i++){
            var td = document.createElement('td');
            td.id='td_'+i;
            if(i==0)
                td.innerHTML = j;
            if(i==1)
                td.innerHTML = item.fio;
            if(i==2)
                td.innerHTML = item.gender;
            if(i==3)
                td.innerHTML = item.birthDate;
            if(i==4)
                td.innerHTML = item.phone;
            tr.appendChild(td);
        }
        j++;
    });
}
function test(){
    alert('asd');
}
function send_sub(){

    var ajax = new XMLHttpRequest();
    var x = document.getElementById('inp_log').value;
    var z = document.getElementById('inp_pass').value;
    var url = 'http://localhost:8080/webservis/login?username=' + x + '&password=' + z;
    ajax.open('GET',url,false);
    ajax.send();

    var response = ajax.responseText;
    alert(response);
}

