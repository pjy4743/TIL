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

       

   - 브라우저 접두사 자동으로 붙이기

     - 자동으로 붙이지 않았을 때의 코드

       > 각 브라우저마다 접두사를 붙여야 되므로, 같은 소스를 5번 작성해야 함

       ![https://raw.githubusercontent.com/pjy4743/TIL/master/CSS/CSS%20%EA%B8%B0%EC%B4%88/html%20files/images/transform.png](https://raw.githubusercontent.com/pjy4743/TIL/master/CSS/CSS 기초/html files/images/transform.png)

       ```css
       /* 예제 - transform.html */
       
       <!DOCTYPE html>
       <html lang="ko" dir="ltr">
         <head>
           <meta charset="utf-8">
           <title>사각형 회전</title>
           <style media="screen">
             .box:hover {
               -webkit-transform:rotate(15deg);
               -moz-transform:rotate(15deg);
               -o-transform:rotate(15deg);
               -ms-transform:rotate(15deg);
               transform:rotate(15deg);
             }
             div {
               border:solid green;
               width:140px;
               height:20px;
               padding:15px 20px;
               text-align:center;
             }
           </style>
         </head>
         <body>
           <div class="box">Mouse Over
       
           </div>
         </body>
       </html>
       
       ```

       

     - 접두사를 자동으로 붙이기

       - **-prefix-free** 자바 스크립트 파일을 이용

         > 접두어 생략으로 소스가 간단해짐

         ```css
         /* 예제 - transform-prefix-free.html */
         
         <!DOCTYPE html>
         <html lang="ko" dir="ltr">
           <head>
             <meta charset="utf-8">
             <title>사각형 회전</title>
             <script src="prefixfree.min.js"></script>
             <style media="screen">
               .box:hover {
                 transform:rotate(15deg);
               }
               div {
                 border:solid green;
                 width:140px;
                 height:20px;
                 padding:15px 20px;
                 text-align:center;
               }
             </style>
           </head>
           <body>
             <div class="box">Mouse Over</div>
           </body>
         </html>
         
         ```

         