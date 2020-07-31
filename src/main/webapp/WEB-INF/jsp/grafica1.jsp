<%@ include file="common/headerg.jspf"%>

<!-- Styles -->
<style>
    #chartdiv {
        width: 100%;
        height: 500px;
    }


    .ampopup-content {
        background: rgb(60, 171, 255) !important;
        background-color: rgba(60, 171, 255, 0.8) !important;
    }
</style>

<div class="container">
    
    <script src="js/libs/amcharts4/core.js"></script>
    <script src="js/libs/amcharts4/charts.js"></script>
    <script src="js/libs/amcharts4/themes/animated.js"></script>
    <!--script src="js/libs/grafica/grafica.js"></script-->
    <div id="chartdiv"></div>
    <script>
                    am4core.ready(function () {
                        // Themes begin
                        am4core.useTheme(am4themes_animated);
                        // Themes end
                        // Create chart instance
                        var chart = am4core.create("chartdiv", am4charts.XYChart);
                        chart.responsive.enabled = true;

                        // Create axes
                        var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
                        var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

                        dateAxis.baseInterval = {
                            "timeUnit": "month",
                            "count": 1
                        };

                        var mySeriesNames = [];
                        var mySeries = [];

                        <c:forEach var="coleccion" items="${dataModular}">
                            var ${coleccion.key} = ${json:toJson(coleccion.value)};
                            mySeriesNames.push("${coleccion.key}");
                            mySeries.push(${coleccion.key});
                        </c:forEach>

                        for (var i = 0; i < mySeries.length; i++) {
                            var serie = mySeries[i];
                            var data = [];
                            for (var j = 0; j < serie.length; j++) {
                                var dataItem = {
                                    date: new Date(serie[j].date)
                                };
                                dataItem["value"] = serie[j].value;
                                data.push(dataItem);
                            }
                            createSeries(mySeriesNames[i], data);
                        }

                        // Create series
                        function createSeries(name, data) {
                            var series = chart.series.push(new am4charts.LineSeries());
                            series.dataFields.dateX = "date";
                            series.dataFields.valueY = "value";
                            series.name = name;
                            series.tooltipText = "{value}"
                            series.strokeWidth = 2;
                            series.minBulletDistance = 15;

                            // Drop-shaped tooltips
                            series.tooltip.background.cornerRadius = 20;
                            series.tooltip.background.strokeOpacity = 0;
                            series.tooltip.pointerOrientation = "vertical";
                            series.tooltip.label.minWidth = 40;
                            series.tooltip.label.minHeight = 40;
                            series.tooltip.label.textAlign = "middle";
                            series.tooltip.label.textValign = "middle";

                            // Make bullets grow on hover
                            var bullet = series.bullets.push(new am4charts.CircleBullet());
                            bullet.circle.strokeWidth = 2;
                            bullet.circle.radius = 4;
                            bullet.circle.fill = am4core.color("#fff");

                            var bullethover = bullet.states.create("hover");
                            bullethover.properties.scale = 1.3;
                            // Make a panning cursor
                            chart.cursor = new am4charts.XYCursor();
                            chart.cursor.behavior = "panXY";
                            chart.cursor.xAxis = dateAxis;
                            chart.cursor.snapToSeries = series;

                            // Create vertical scrollbar and place it before the value axis
                            chart.scrollbarY = new am4core.Scrollbar();
                            chart.scrollbarY.parent = chart.leftAxesContainer;
                            chart.scrollbarY.toBack();

                            // Create a horizontal scrollbar with previe and place it underneath the date axis
                            chart.scrollbarX = new am4charts.XYChartScrollbar();
                            chart.scrollbarX.series.push(series);
                            chart.scrollbarX.parent = chart.bottomAxesContainer;

                            dateAxis.start = 0.79;
                            dateAxis.keepSelection = true;




                            var segment = series.segments.template;
                            segment.interactionsEnabled = true;

                            var hoverState = segment.states.create("hover");
                            hoverState.properties.strokeWidth = 3;

                            var dimmed = segment.states.create("dimmed");
                            dimmed.properties.stroke = am4core.color("#dadada");

                            segment.events.on("over", function (event) {
                                processOver(event.target.parent.parent.parent);
                            });

                            segment.events.on("out", function (event) {
                                processOut(event.target.parent.parent.parent);
                            });
                            series.data = data;
                            return series;
                        }

                        chart.legend = new am4charts.Legend();
                        chart.legend.position = "right";
                        chart.legend.scrollable = true;
                        chart.legend.itemContainers.template.events.on("over", function (event) {
                            processOver(event.target.dataItem.dataContext);
                        })

                        chart.legend.itemContainers.template.events.on("out", function (event) {
                            processOut(event.target.dataItem.dataContext);
                        })

                        function processOver(hoveredSeries) {
                            hoveredSeries.toFront();

                            hoveredSeries.segments.each(function (segment) {
                                segment.setState("hover");
                            })

                            chart.series.each(function (series) {
                                if (series != hoveredSeries) {
                                    series.segments.each(function (segment) {
                                        segment.setState("dimmed");
                                    })
                                    series.bulletsContainer.setState("dimmed");
                                }
                            });
                        }

                        function processOut(hoveredSeries) {
                            chart.series.each(function (series) {
                                series.segments.each(function (segment) {
                                    segment.setState("default");
                                })
                                series.bulletsContainer.setState("default");
                            });
                        }


                    }); // end am4core.ready()
                </script>


</div>

<%@ include file="common/footer.jspf"%>