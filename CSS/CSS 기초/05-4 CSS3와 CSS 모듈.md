# 05. CSS 기초

## * 목차

- **05-1** 스타일과 스타일 시트
- **05-2** 주요 선택자
- **05-3**  캐스캐이딩 스타일 시트(CSS)
- <u>**05-4** CSS3와 CSS 모듈</u>



### 05-4. CSS3와 CSS 모듈

1. CSS3란?

   - CSS1 -> CSS2를 거쳐 개발된 스타일 시트의 기본

     > CSS2 - 규약 내에 스타일과 관련된 것들이 한꺼번에 담겨 있음
     >
     > -----> 덩치가 크고 복잡하여 한 번에 업데이트가 어려움

   - CSS 모듈

     - 배경 / 글꼴/ 박스 모델 등 수십 개의 기능을 주제별로 따로 만든 것

       > 완성도가 각기 달라서 모듈에 따라 브라우저 지원 여부가 다름


   

2. CSS3와 브라우저 접두사(prefix)

   - CSS 모듈이 표준 규약이 아닌 속성들은 브라우저에 따라 다른 방식으로 지원됨

   - 속성 이름 앞에 접두사(prefix)를 붙여 브라우저별로 구분
   
     * **브라우저별 접두사**
   
       |  접두사  |                    설명                     |
       | :------: | :-----------------------------------------: |
       | -webkit- |   웹키트 방식 브라우저용(사파리, 크롬 등)   |
       |  -moz-   | 게코 방식 브라우저용(모질라, 파이어폭스 등) |
       |   -o-    |               오페라 브라우저               |
    |   -ms-   |      마이크로소프트 인터넷 익스플로러       |
   
  * 접두사 사용법
   
    * 각 브라우저 접두사를 붙인 속성을 먼저 쓰고, 표준이 정해진 후 사용할 속성을 맨 마지막에 사용
   
    ```css
       -webkit-column-count:3;		/* 사파리와 크롬 브라우저용 속성 */
    -moz-column-count:3;		/* 파이어폭스 브라우저용 속성   */
       column-count:3				/* 표준이 정해진 후 사용할 속성 */
    ```
   
    
   
  * 사용자 스타일 시트가 최우선!
   
    * **저시력자**나 **색약자** 등 특별한 조건이 필요한 사용자가 그들에게 맞게 구성해 놓은 스타일 시트
   
      > ex. 고대비
   
  * 중요 스타일 **!important**
   
       * 제작자 스타일 시트
   
      * 사이트를 제작하면서 만든 스타일 시트
   
    * 일반 스타일
   
         * 스타일 시트에서 작성하는 스타일 규칙

       * 중요 스타일

         * 다른 어느 스타일보다 최우선 적용해야 할 스타일
   
           > 뒤에 !important 를 붙여 나타냄
           >
           > 제작자가 만든 일반 스타일보다 우선시 됨
   
       * 기본적인 브라우저 스타일 시트
   
         * 브라우저마다 기본적으로 지정하고 있는 스타일
         * **스타일을 따로 지정하지 않으면 브라우저 스타일로 지정됨**
   
     ![https://raw.githubusercontent.com/pjy4743/TIL/master/CSS/CSS%20%EA%B8%B0%EC%B4%88/html%20files/images/cascading1.png](https://raw.githubusercontent.com/pjy4743/TIL/master/CSS/CSS 기초/html files/images/cascading1.png)
   
     ```css
     /* 예제 - cacasting1.html */
     
     <!DOCTYPE html>
     <html lang="ko" dir="ltr">
       <head>
         <meta charset="utf-8">
         <title>세계 3대 미항</title>
         <style media="screen">
           p {
             font-style:italic;  /* 글자 스타일 */
             color:blue; /* 글자 색 */
           }
           p {
          color:red !important; /* 글자 색 우선 적용 */
           }
      </style>
       </head>
    <body>
         <h1>세계 3대 미항</h1>
      <img src="images/rio.jpg" alt="브라질 리우데자네이루">
         <p>시드니(Sydney), 호주</p>
         <p>리우데자네이루(Rio de Janeiro), 브라질</p>
         <p>나폴리(Naples), 이탈리아</p>
       </body>
     </html>
     ```
   
     

   - 얼마나 한정지을 수 있는가 - **명시도(Specificity)**

     

     ```flow
  op_inline=>operation: 인라인 스타일
     op_id=>operation: id 스타일
     op_class=>operation: 클래스 스타일
  op_tag=>operation: 태그 스타일
     
  op_inline->op_id->op_class->op_tag
     ```
   
  - 인라인 스타일
   
    - 태그 안에 style 속성을 사용해 해당 태그에만 스타일 적용
   
  - id 스타일
   
    - **한 문서에 한 번만 적용**
       - 선택자 이름 앞에 **#을 붙여 표시**
   
     - 클래스 스타일
   
       - **한 문서 안에 여러 번 적용 가능**
       - 선택자 이름 앞에 **마침표(.)을 붙여 표시**
   
     - 태그 스타일
   
       - 특정 태그가 달린 곳에 똑같이 적용되는 스타일
   
         ![https://raw.githubusercontent.com/pjy4743/TIL/master/CSS/CSS%20%EA%B8%B0%EC%B4%88/html%20files/images/cascading2.png](https://raw.githubusercontent.com/pjy4743/TIL/master/CSS/CSS 기초/html files/images/cascading2.png)
   
         ```css
         /* 예제 - cascation2.html */
         
         <!DOCTYPE html>
         <html lang="ko" dir="ltr">
           <head>
             <meta charset="utf-8">
             <title>세계 3대 미항</title>
             <style media="screen">
               h1 {
                 color:blue; /* 글자 색 */
               }
               #habor {
                 border:1px solid gray; /* 테두리 -1픽셀짜리 회색 실선 */
                 padding:10px; /* 패딩 여백 - 테두리와 내용 사이의 여백 */
                 color:green;  /* 글자 색 */
               }
               .heading {
              color:red; /* 글자 색 */
               }
          </style>
           </head>
        <body>
             <h1 class="heading" id="habor">세계 3대 미항</h1>
          <img src="images/rio.jpg" alt="브라질 리우데자네이루">
             <p>시드니(Sydney), 호주</p>
          <p>리우데자네이루(Rio de Janeiro), 브라질</p>
             <p>나폴리(Naples), 이탈리아</p>
        </body>
         </html>
      ```
   
  
   
   - 소스에서의 순서
   
     ![https://github.com/pjy4743/TIL/blob/master/CSS/CSS%20%EA%B8%B0%EC%B4%88/html%20files/images/inheritance.png?raw=true](https://github.com/pjy4743/TIL/blob/master/CSS/CSS 기초/html files/images/inheritance.png?raw=true)
   
     - 스타일 상속
   
       - 자식 요소에서 별도로 스타일을 지정하지 않으면 부모 요소에 있는 스타일 속성들이 자식 요소로 전달됨
   
       - **배경 색과 배경 이미지는 상속되지 않고 기본 값인 "투명"으로 지정됨**
   
         ![https://raw.githubusercontent.com/pjy4743/TIL/master/CSS/CSS%20%EA%B8%B0%EC%B4%88/html%20files/images/inherit.png](https://raw.githubusercontent.com/pjy4743/TIL/master/CSS/CSS 기초/html files/images/inherit.png)
   
         ```css
         /* 예제 - inherit.html */
         
         <!DOCTYPE html>
         <html lang="ko" dir="ltr">
           <head>
             <meta charset="utf-8">
             <title>슈퍼푸드</title>
             <style media="screen">
               body {
                 font-family:"돋움"; /* 글꼴 */
                 color:darkgreen; /* 글자 색 */
               }
             </style>
           </head>
           <body>
             <h1>뉴욕 타임즈에서 발표한 세계 10대 슈퍼 푸드</h1>
             <ul>
               <li>블루베리</li>
            <li>귀리</li>
               <li>토마토</li>
               <li>시금치</li>
               <li>적포도주</li>
               <li>견과류</li>
               <li>브로콜리</li>
               <li>연어</li>
               <li>마늘</li>
               <li>녹차</li>
             </ul>
           </body>
         </html>
         ```
   
         