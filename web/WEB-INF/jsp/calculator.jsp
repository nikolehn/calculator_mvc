<!doctype html>

<html lang="en">
    <head>
        <meta charset="utf-8">

        <title>UNED Calculator MVC</title>
        <meta name="description" content="UNED Calculator MVC">
        <meta name="author" content="Nikole Yanez">

        <link href='http://fonts.googleapis.com/css?family=Ubuntu+Mono:400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css?v=1.0">
        <script src="${pageContext.request.contextPath}/static/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/calculator.js"></script>

        <!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>
    <body>

        <div id="calculator">

            <table id="display">
                <tbody>
                    <tr>
                        <td>
                            <div id="history-scroll">
                                <p id="history"></p>
                            </div>
                        </td>
                    </tr>
                    <tr><td><p id="input"></p></td></tr>
                </tbody>
            </table>

            <table id="keyboard">
                <tbody>
                    <tr>
                        <td><button id="mread" class="op0" type="button">MR</button></td>
                        <td><button id="madd" class="op1" type="button">M+</button></td>
                        <td><button id="msubtract" class="op1" type="button">M-</button></td>
                        <td><button id="mclear" class="op0" type="button">MC</button></td>
                        <td><button id="clear" type="button">C</button></td>
                    </tr>
                    <tr>
                        <td><button id="sin" class="op1" type="button">sin</button></td>
                        <td><button id="cos" class="op1" type="button">cos</button></td>
                        <td><button id="tan" class="op1" type="button">tan</button></td>
                        <td><button id="log" class="op1" type="button">log</button></td>
                        <td><button id="exp" class="op1" type="button">e</button></td>
                    </tr>
                    <tr>
                        <td><button type="button" class="num">7</button></td>
                        <td><button type="button" class="num">8</button></td>
                        <td><button type="button" class="num">9</button></td>
                        <td><button id="sqrt" class="op1" type="button">&#8730;</button></td>
                        <td><button id="pow" class="op2" type="button">^</button></td>
                    </tr>
                    <tr>
                        <td><button type="button" class="num">4</button></td>
                        <td><button type="button" class="num">5</button></td>
                        <td><button type="button" class="num">6</button></td>
                        <td><button id="divide" class="op2" type="button">&#247;</button></td>
                        <td><button id="multiply" class="op2" type="button">x</button></td>
                    </tr>
                    <tr>
                        <td><button type="button" class="num">1</button></td>
                        <td><button type="button" class="num">2</button></td>
                        <td><button type="button" class="num">3</button></td>
                        <td colspan="1" rowspan="2"><button id="add" class="op2" type="button">+</button></td>
                        <td><button id="subtract" class="op2" type="button">-</button></td>
                    </tr>
                    <tr>
                        <td colspan="2" rowspan="1"><button type="button" class="num">0</button></td>
                        <td><button id="dot" type="button">.</button></td>
                        <td><button id="eq" type="button">=</button></td>
                    </tr>
                </tbody>
            </table>

        </div> <!-- calculator -->

    </body>
</html>
