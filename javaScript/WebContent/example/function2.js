var score = 10; // 전역 변수
function myFunc() {
    var score = 20; // 로컬 변수
    console.log("local: " + score);
}
myFunc();
console.log("global: " + score);

function newFunc() {
    console.log("global function");
}

function outerFunc() {

    function newFunc() {
        console.log("local function");
    }
    newFunc();
}
newFunc();
outerFunc();

(function () {
    console.log("return Fnc");
})();