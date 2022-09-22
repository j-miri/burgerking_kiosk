// 홈메뉴 슬라이드
var slideWrapper = document.querySelector('.container');
var slides = document.querySelectorAll('.slide_img');
var totalSlides = slides.length;

var sliderWidth = slideWrapper.clientWidth;
var slideIndex = 0;
var slider = document.querySelector('.slider');

showSlides()

function showSlides() {
    for(let i=0;i<slides.length;i++){
        slider.style.left = -(sliderWidth * slideIndex) + 'px';    
    }
    slideIndex++;
    if (slideIndex === totalSlides) {
        slideIndex = 0;
    }
    setTimeout(showSlides, 2000); 
}


// 메뉴명 클릭시 메뉴판 이미지 변경 변수
let menu_home = document.getElementsByTagName("li")[0];
let menu_burger = document.getElementsByTagName("li")[1];
let menu_drink = document.getElementsByTagName("li")[2];
let menu_side = document.getElementsByTagName("li")[3];
let home = document.querySelector("#home")
let hamburger = document.querySelector("#hamburger")
let drink = document.querySelector("#drink")
let side = document.querySelector("#side")

// 메뉴판이미지 변경 함수
menu_home.addEventListener("click",function(){

    menu_home.style.color="rgb(245, 130, 49)";
    menu_burger.style.color="black";
    menu_drink.style.color="black";
    menu_side.style.color="black";
    
    home.style.display="flex";
    hamburger.style.display="none";
    side.style.display="none";
    drink.style.display="none";
})
menu_burger.addEventListener("click",function(){

    menu_home.style.color="black";
    menu_burger.style.color="rgb(245, 130, 49)";
    menu_drink.style.color="black";
    menu_side.style.color="black";
    
    home.style.display="none";
    hamburger.style.display="inline-block";
    side.style.display="none";
    drink.style.display="none";
})
menu_drink.addEventListener("click",function(){
    
    menu_home.style.color="black";
    menu_burger.style.color="black";
    menu_drink.style.color="rgb(245, 130, 49)";
    menu_side.style.color="black";
    
    home.style.display="none";
    hamburger.style.display="none";
    side.style.display="none";
    drink.style.display="inline-block";
})
menu_side.addEventListener("click",function(){
    
    menu_home.style.color="black";
    menu_burger.style.color="black";
    menu_drink.style.color="black";
    menu_side.style.color="rgb(245, 130, 49)";

    home.style.display="none";
    hamburger.style.display="none";
    side.style.display="inline-block";
    drink.style.display="none";
})

// aside 결제창
let monster = document.getElementById("hamburger").firstElementChild;
let cheese = document.getElementById("hamburger").children[1];
let shrimp = document.getElementById("hamburger").lastElementChild;
let coleslaw = document.getElementById("side").firstElementChild;
let basak = document.getElementById("side").children[1];
let potatoes = document.getElementById("side").lastElementChild;
let coke = document.getElementById("drink").firstElementChild;
let sprite = document.getElementById("drink").children[1];
let chocolate = document.getElementById("drink").lastElementChild;
let basket = document.getElementById("basket");

// 클릭 했을때, 행동>함수연결
monster.addEventListener("click",pay_win);
cheese.addEventListener("click",pay_win);
shrimp.addEventListener("click",pay_win);
coleslaw.addEventListener("click",pay_win);
basak.addEventListener("click",pay_win);
potatoes.addEventListener("click",pay_win);
coke.addEventListener("click",pay_win);
sprite.addEventListener("click",pay_win);
chocolate.addEventListener("click",pay_win);

// 메뉴 수량 * 가격 담을 변수
let won = 0;

//  함수
function pay_win(){
    if(basket.children.length > 0){
        let count =0 ;
        for(let i=0; i<basket.children.length; i++){
            if(this.id == basket.children[i].className){
                count++;
                let arr = basket.children[i].children;
                // HTMLCollection(5) [spen, button.btn_style, button.btn_style, button.btn_style, input]

                // 같은 메뉴 버튼 눌렀을 경우 수량, 합계 변화
                arr[0].innerHTML = Number(arr[0].innerHTML) + 1;                // 수량 변화
                arr[4].name = Number(arr[0].innerHTML) * Number(arr[4].value);  // 수량*가격 변화

                // 결제창 아래 합계 가격도 바뀌도록...
                total_sum();
            }
        }
        if (count == 0 ){
            let div = document.createElement("div");                // 아래 만든 태그들 담을 태그임.
            let spen = document.createElement("spen");              // 메뉴명
            let up_btn = document.createElement("button");          // + 버튼 : 수량 ++
            let down_btn = document.createElement("button");        // - 버튼 : 수량 --
            let input = document.createElement("input")             // 히든태그 : vlaue=1개가격, name=수량*가격  
            let delete_btn = document.createElement("button");      // x 버튼 : 누르면 부모 div 삭제
            let price = document.getElementById(this.id).lastElementChild.value;        // 1개당 가격
        
            let id = this.id;

            // 버튼에 값 추가, 버튼 꾸미기위해 className 지정.
            up_btn.innerHTML="+";
            up_btn.className = "btn_style";
            down_btn.innerHTML="-";
            down_btn.className = "btn_style";
            delete_btn.innerHTML = "x";
            delete_btn.className = "btn_style";

            // input태그 hidden
            input.type = "hidden";
            input.value = price;            // 1개당 가격
            input.name = price;             // 수량 * 가격

            // aside에 div태그 추가, div태그에 나머지 태그 추가, text 입력.
            basket.appendChild(div);
            div.innerHTML= id;
            div.className= id;
            div.appendChild(spen);
            spen.innerHTML= 1 ;
            div.appendChild(up_btn);
            div.appendChild(down_btn);
            div.appendChild(delete_btn);
            div.appendChild(input);
            
            // 메뉴 처음 선택 했을때 메뉴1개 일떄 합계에 가격 뜨도록 함수 넣음.
            total_sum();


            // +,- 버튼 클릭시 숫자변화.
            // 수량 * 가격 input.name에 담기
            up_btn.onclick = function(){
                spen.innerHTML ++;
                won = Number(spen.innerHTML)*Number(price);
                input.name = won;
                total_sum();        // 모든 메뉴 수량*가격 의 총합
            }
            down_btn.onclick = function(){
                if(spen.innerHTML >1){
                    spen.innerHTML --;
                    won = Number(spen.innerHTML)*Number(price);
                    input.name = won;
                    total_sum();    // 모든 메뉴 수량*가격 의 총합
                }
            }

            // x 버튼 클릭시 삭제
            delete_btn.onclick = function(){
                document.getElementsByClassName(id)[0].remove();
                total_sum();        // 모든 메뉴 수량*가격 의 총합
            }

            // +,-,x버튼 위치 스타일.
            div.style.margin = "12px";
            div.style.position="relative";
            up_btn.style.position="absolute";
            down_btn.style.position="absolute";
            delete_btn.style.position="absolute";
            up_btn.style.right="90px";
            down_btn.style.right="60px";
            delete_btn.style.right="30px";
        }   
    }else{
        let div = document.createElement("div");                // 아래 만든 태그들 담을 태그임.
        let spen = document.createElement("spen");              // 메뉴명
        let up_btn = document.createElement("button");          // + 버튼 : 수량 ++
        let down_btn = document.createElement("button");        // - 버튼 : 수량 --
        let input = document.createElement("input")             // 히든태그 : vlaue=1개가격, name=수량*가격  
        let delete_btn = document.createElement("button");      // x 버튼 : 누르면 부모 div 삭제
        let price = document.getElementById(this.id).lastElementChild.value;        // 1개당 가격
    
        let id = this.id;

        // 버튼에 값 추가, 버튼 꾸미기위해 className 지정.
        up_btn.innerHTML="+";
        up_btn.className = "btn_style";
        down_btn.innerHTML="-" + "<br>";
        down_btn.className = "btn_style";
        delete_btn.innerHTML = "x";
        delete_btn.className = "btn_style";

        // input태그 hidden
        input.type = "hidden";
        input.value = price;            // 1개당 가격
        input.name = price;             // 수량*가격

        // aside에 div태그 추가, div태그에 나머지 태그 추가, text 입력.
        basket.appendChild(div);
        div.innerHTML= id;
        div.className= id;
        div.appendChild(spen);
        spen.innerHTML= 1 ;
        div.appendChild(up_btn);
        div.appendChild(down_btn);
        div.appendChild(delete_btn);
        div.appendChild(input);
        
        // 메뉴 처음 선택 했을때 메뉴1개 일떄 합계에 가격 뜨도록 함수 넣음.
        total_sum();                // 모든 메뉴 수량*가격 의 총합


        // +,- 버튼 클릭시 숫자변화.
        // 갯수*가격 input.value에 담기
        up_btn.onclick = function(){
            spen.innerHTML ++;
            won = Number(spen.innerHTML)*Number(price);
            input.name = won;
            total_sum();            // 모든 메뉴 수량*가격 의 총합
        }
        down_btn.onclick = function(){
            if(spen.innerHTML >1){
                spen.innerHTML --;
                won = Number(spen.innerHTML)*Number(price);
                input.name = won;
                total_sum();        // 모든 메뉴 수량*가격 의 총합
            }
        }
        // x 버튼 클릭시 삭제
        delete_btn.onclick = function(){
            document.getElementsByClassName(id)[0].remove();
            total_sum();            // 모든 메뉴 수량*가격 의 총합
        }

        // +,-,x버튼 위치 스타일.
        div.style.margin = "12px";
        div.style.position="relative";
        up_btn.style.position="absolute";
        down_btn.style.position="absolute";
        delete_btn.style.position="absolute";
        up_btn.style.right="90px";
        down_btn.style.right="60px";
        delete_btn.style.right="30px";
    }
}


// 총 합계 가격 - 모든메뉴 갯수*가격의 합
function total_sum(){
    let sum_all = 0;
    for(let i=0; i<basket.children.length; i++){
        sum_all += Number(basket.children[i].lastElementChild.name);

    }
    document.getElementById("total").innerHTML = sum_all;
}


// 합계
let total = document.getElementById("total").innerHTML;


// 결제버튼 클릭시
let payment_reset = document.getElementById("payment");

payment_reset.addEventListener("click", function(){

    if(basket.children.length==0){
        alert("결제할 상품이 없습니다.");
    }else{
        alert("총 금액은 " + document.getElementById("total").innerHTML + " 입니다." );
        let userYn = confirm("포장이신가요?");
        if(userYn){
            alert("포장되었습니다.\n안녕히가세요");
        }else{
            alert("매대에 음식 나왔습니다.\n 맛있게 드세요.");
        }
        removeAllchild(basket);
        document.getElementById("total").innerHTML = "";
    }
});

// 취소버튼 클릭시 리셋
let reset = document.getElementById("reset");

reset.addEventListener('click', function () {

    removeAllchild(basket); //안에 존재한는 element 삭제
    document.getElementById("total").innerHTML= ""; 
});

function removeAllchild(div) {
    while (div.hasChildNodes()) {
        div.removeChild(div.firstChild);
    }
}