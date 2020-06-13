# 05. CSS 기초

## * 목차

- **05-1** 스타일과 스타일 시트
- **05-2** 주요 선택자
- **05-3**  캐스캐이딩 스타일 시트(CSS)
- **05-4** CSS3와 CSS 모듈



### * 맛보기 손 코딩

		>스타일 시트 미리 보기

---

#### ※ 05장에서 배울 핵심

 * **< style >** - 스타일 시트를 정의하는 태그

 * ***{ 속성 }** - 문서 전체에 스타일을 적용하는 전체 선택자

 * **태그 { 속성 }** - 태그에 스타일을 적용하는 태그 선택자

 * **.스타일 이름 { 속성 }** - class 속성으로 묶은 특정 부분에만 스타일을 적용하는 클래스 선택자

 * **#스타일 이름 { 속성 }** - id 속성으로 묶은 부분에만 스타일을 적용하는 id 선택자

 * **이름1, 이름2, ... { 속성 }** - 여러 항목에 같은 스타일을 적용하는 그룹 선택자

   ```css
   <style>
   	p { color:blue; font-size:1.5em; } /* 태그 선택자 */
   	.accent { font-weight:bold; font-size:2em; color:red; } /* 클래스 선택자 */
   	#wrapper { width:300px; padding:10px; border:1px solid black; } /* id 선택자 */
   </style>
   
   <div id="wrapper">
   	<h1>표준 윕 기술</h1>
   	<p><span class="accent">H</span>TML</p>
   	<p><span class="accent">C</span>SS</p>
   	<p><span class="accent">J</span>avascript</p>
   </div>
   ```

   