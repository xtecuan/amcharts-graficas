<%@ include file="common/headerg.jspf"%>

<div class="container">
    <div id="chartdiv"></div>
    <script src="js/libs/amcharts4/core.js"></script>
    <script src="js/libs/amcharts4/charts.js"></script>
    <script src="js/libs/amcharts4/themes/animated.js"></script>
    <!--script src="js/libs/grafica/grafica.js"></script-->

    <script>
        am4core.ready(function() {
            // Themes begin
            am4core.useTheme(am4themes_animated);
            // Themes end
            // Create chart instance
            var chart = am4core.create("chartdiv", am4charts.XYChart);

            // Create axes
            var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
            var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

            var mySeriesNames = [];
            var mySeries=[];

            <c:forEach var="coleccion" items="${dataModular}">
                var ${coleccion.key} = ${json:toJson(coleccion.value)};
                mySeriesNames.push("${coleccion.key}");
                mySeries.push(${coleccion.key});
            </c:forEach>

            for (var i = 0; i < mySeries.length; i++) {
                var serie = mySeries[i];
                var data = [];
                for(var j=0;j<serie.length;j++){
                    var dataItem = {
                        date: new Date(serie[j].time)
                    };
                    dataItem["value"+"value"+i]=serie[j].value;
                    data.push(dataItem);
                }
                createSeries("value" + i, mySeriesNames[i],data);
            }

            // Create series
            function createSeries(s, name, data) {
                var series = chart.series.push(new am4charts.LineSeries());
                series.dataFields.valueY = "value" + s;
                series.dataFields.dateX = "date";
                series.name = name;

                var segment = series.segments.template;
                segment.interactionsEnabled = true;

                var hoverState = segment.states.create("hover");
                hoverState.properties.strokeWidth = 3;

                var dimmed = segment.states.create("dimmed");
                dimmed.properties.stroke = am4core.color("#dadada");

                segment.events.on("over", function(event) {
                    processOver(event.target.parent.parent.parent);
                });

                segment.events.on("out", function(event) {
                    processOut(event.target.parent.parent.parent);
                });
                series.data = data;
                return series;
            }

            chart.legend = new am4charts.Legend();
            chart.legend.position = "right";
            chart.legend.scrollable = true;
            chart.legend.itemContainers.template.events.on("over", function(event) {
                processOver(event.target.dataItem.dataContext);
            })

            chart.legend.itemContainers.template.events.on("out", function(event) {
                processOut(event.target.dataItem.dataContext);
            })

            function processOver(hoveredSeries) {
                hoveredSeries.toFront();

                hoveredSeries.segments.each(function(segment) {
                    segment.setState("hover");
                })

                chart.series.each(function(series) {
                    if (series != hoveredSeries) {
                        series.segments.each(function(segment) {
                            segment.setState("dimmed");
                        })
                        series.bulletsContainer.setState("dimmed");
                    }
                });
            }

            function processOut(hoveredSeries) {
                chart.series.each(function(series) {
                    series.segments.each(function(segment) {
                        segment.setState("default");
                    })
                    series.bulletsContainer.setState("default");
                });
            }


        }); // end am4core.ready()
    </script>

</div>
    </script>
</div>

<%@ include file="common/footer.jspf"%>