<%@ include file="common/headerg.jspf"%>

<!-- Styles -->
<style>
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
        }

        #chartdiv {
            width: 100%;
            height: 500px;
        }
</style>

<div class="container">
    
    <script src="js/libs/amcharts4/core.js"></script>
    <script src="js/libs/amcharts4/charts.js"></script>
    <script src="js/libs/amcharts4/lang/es_ES.js"></script>
    <script src="js/libs/amcharts4/lang/en_US.js"></script>
    <script src="js/libs/amcharts4/themes/animated.js"></script>
    <script src="js/libs/amcharts4/themes/material.js"></script>
    <script src="js/libs/amcharts4/themes/dark.js"></script>
    <script src="js/libs/grafica/grafica.js"></script>
    <div id="chartdiv"></div>

    <script>
        var mySeriesNames = [];
        var mySeries = [];

        <c:forEach var="coleccion" items="${dataModular}">
            var ${coleccion.key} = ${json:toJson(coleccion.value)};
            mySeriesNames.push("${coleccion.key}");
            mySeries.push(${coleccion.key});
        </c:forEach>

        createGraph(mySeriesNames,mySeries,"chartdiv");

    </script>
    
</div>

<%@ include file="common/footer.jspf"%>