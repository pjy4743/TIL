# 05. CSS 기초

## * 목차

- **05-1** 스타일과 스타일 시트
- **05-2** 주요 선택자
- **05-3**  캐스캐이딩 스타일 시트(CSS)
- **05-4** CSS3와 CSS 모듈



### * 맛보기 손 코딩

> 스타일 시트 미리 보기

---

#### ※ 05장에서 배울 핵심

 * **< style >** - 스타일 시트를 정의하는 태그

 * ***{ 속성 }** - 문서 전체에 스타일을 적용하는 전체 선택자

 * **태그 { 속성 }** - 태그에 스타일을 적용하는 태그 선택자

 * **.스타일 이름 { 속성 }** - class 속성으로 묶은 특정 부분에만 스타일을 적용하는 클래스 선택자

 * **#스타일 이름 { 속성 }** - id 속성으로 묶은 부분에만 스타일을 적용하는 id 선택자

 * **이름1, 이름2, ... { 속성 }** - 여러 항목에 같은 스타일을 적용하는 그룹 선택자

   

   

   ![https://raw.githubusercontent.com/pjy4743/TIL/master/CSS/CSS%20%EA%B8%B0%EC%B4%88/images/preview.png](https://raw.githubusercontent.com/pjy4743/TIL/master/CSS/CSS 기초/images/preview.png)

   ```css
   <style>
   	p { color:blue; font-size:1.5em; } /* 태그 선택자 */
   	.accent { font-weight:bold; font-size:2em; color:red; } /* 클래스 선택자 */
   	#wrapper { width:300px; padding:10px; border:1px solid black; } /* id 선택자 */
   </style>
   
   <div id="wrapper">
   	<h1>표준 웹 기술</h1>
   	<p><span class="accent">H</span>TML</p>
   	<p><span class="accent">C</span>SS</p>
   	<p><span class="accent">J</span>avascript</p>
   </div>
   ```

   

### 05-1. 스타일과 스타일 시트

1. 스타일(Style)

   - HTML 문서에서 자주 사용하는 글꼴이나 색상, 정렬, 각 요소들의 배치 방법

   - 문서의 겉모습을 결정짓는 내용

     

2. 스타일을 사용하는 이유

   - **웹 문서의 내용과 상관 없이 디자인만 바꿀 수 있음**
     - 내용과 디자인 수정 시 상호간 영향을 미치지 않음
     
     - 다양한 기기에 맞게 CSS만 바꿔주어 플랫폼마다 따로 문서를 만들지 않아도 됨
     
       

3. 스타일 형식

   ```css
   p { text-align: center; } /* 텍스트 단락을 중앙에 정렬하는 스타일 규칙 */
   ```

   |        규칙         |     이름      |                          사용 방법                           |
   | :-----------------: | :-----------: | :----------------------------------------------------------: |
   |          p          |    선택자     | 앞으로 만들 스타일 규칙의 적용 위치<br />텍스트 단락에 **중괄호({, }) 사이의 스타일을 적용** |
   | text-align : center | 속성 : 속성값 | 속성과 속성 값은 **콜론(:)**으로 구분<br />**속성:속성값**과 같은 형식으로 표시<br />속성과 속성 값 쌍 다음은 **세미콜론(;)**으로 구분 |

   ```css
   /* 스타일 형식 사용의 예(Example) */
   
   p  { color:blue; font-size:16px; } 	 /* 텍스트 단락의 글자 색 파란색, 글자 크기 16px */
   h2 { font-size:20px; color:orange; } /* 2단계 제목의 글자 크기 20px, 글자 색상 주황색 */
   p  { color:blue; } 					 /* 텍스트 단락의 글자 색 파란색 */
   ```

   

4. 스타일 표기 방법

   - **스타일 규칙 : 세미콜론(;)으로 구분해 중괄호({, }) 안에 나열**

     - 속성이 여러개일 경우 여러 줄에 걸쳐서 작성

       ```css
       /* 모두 같은 코드 */
       
       h2 {font-size:20px; color:orange; }
       ```

       ```css
       h2 {
           font-size:20px;
           color:orange;
       }
       ```

       ```css
       h2
       {
           font-size:20px;
           color:orange:
       }
       ```

   

5. 스타일 주석

   - 소스에 설명을 붙이는 것

   - /* **이 사이에 주석의 내용을 입력 ** */

     ![https://raw.githubusercontent.com/pjy4743/TIL/master/CSS/CSS%20%EA%B8%B0%EC%B4%88/images/css-comment.png](https://raw.githubusercontent.com/pjy4743/TIL/master/CSS/CSS 기초/images/css-comment.png)

     ```css
     /* 예제 - css-comment.html */
     
     <!DOCTYPE html>
     <html lang="ko" dir="ltr">
       <head>
         <meta charset="utf-8">
         <title>CSS 적용해 보기</title>
         <style>
           /* h2 제목과
           텍스트 단락의
           스타일을 조절해 보자
           */
           h2 {
             font-size:20px;
             color:orange;
           }
           p {
             color:blue;
           }
         </style>
       </head>
     ```

   

6. 스타일 시트

   - 여러 개의 스타일 규칙을 하나로 묶어 놓은 것

   - **내부 스타일 시트**

     - 웹 문서 안에서 사용할 스타일을 문서 안에 정리

     - ```css
       <style>태그와 </style>태그 사이에 작성	/* 브라우저 화면 표시 전에 스타일 정보가 결정되어야 하므로	*/
       									  /* <head></head>안에서 정의해야 함 					*/
       ```

     - 

