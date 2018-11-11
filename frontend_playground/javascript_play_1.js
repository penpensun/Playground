function changeImage(){
    element = document.getElementById('myimage');
    if (element.src.match("bulbon")){
        element.src="./images/pic_bulboff.gif";
    }
    else{
        element.src="./images/pic_bulbon.gif";
    }
}


var person = {
    firstName : "John",
    lastName : "Doe",
    id: 5566,
    fullName: function(){
        return this.firstName+" "+this.lastName;
    }
}

document.getElementById("demo").innerHTML = person.fullName();
function myFunction(name, job){
    alert("Welcome to Hogwarts "+ name+ ", the "+job);
}

function computeMul(a,b){
    return a*b;
}

function runMul(a, b){
    document.getElementById("demo").innerHTML = computeMul(a,b);
}