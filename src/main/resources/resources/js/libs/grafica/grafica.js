var seriesSettings = {

  Banca : {color: "#FF0000"}, //red
  Tarjetas : {color: "#0000FF"}, //blue
  Comercio : {color: "#00FF00"}, //green
  IMF : {color: "#000000"}, //black
  Hipotecario : {color: "#FF00FF"}, //FUCHSIA
  Total : {color : "#00FF00"} //LIME

};


function createGraph(mySeriesNames,mySeries,divname){

    
    am4core.useTheme(am4themes_material);
    var chart = am4core.create(divname, am4charts.XYChart);
    chart.cursor = new am4charts.XYCursor();

    chart.legend = new am4charts.Legend();
    chart.legend.useDefaultMarker = true;
    var marker = chart.legend.markers.template.children.getIndex(0);

    var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
    dateAxis.dateFormatter = new am4core.DateFormatter();
    dateAxis.dateFormatter.language = new am4core.Language();
    dateAxis.dateFormatter.language.locale = am4lang_es_ES;
    dateAxis.dateFormatter.dateFormat = "MMM/yyyy";
    dateAxis.dateFormats.setKey("month", "MMM/yyyy");
    dateAxis.periodChangeDateFormats.setKey("month", "MMM/yyyy");
    dateAxis.title.text="Periodo";
    dateAxis.cursorTooltipEnabled = false;

    var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
    valueAxis.numberFormatter = new am4core.NumberFormatter();
    valueAxis.numberFormatter.language = new am4core.Language();
    valueAxis.numberFormatter.language.locale = am4lang_en_US;
    valueAxis.numberFormatter.numberFormat ="#,###.00'%'";
    valueAxis.title.text = "% Endeudamiento";
    valueAxis.cursorTooltipEnabled = false;

    for (let i = 0; i < mySeriesNames.length; i++) {
      const serieName = mySeriesNames[i];
      console.log("Processing serie: "+serieName);

      var series1 = chart.series.push(new am4charts.LineSeries());
      series1.name = serieName;
      series1.dataFields.valueY = "value";
      series1.dataFields.dateX = "date";
      series1.tooltipDateFormat = "MMM/yyyy";
      
      
      series1.dateFormatter = new am4core.DateFormatter();
      series1.dateFormatter.language = new am4core.Language();
      series1.dateFormatter.language.locale = am4lang_es_ES;
      series1.dateFormatter.dateFormat = "MMM/yyyy";
      

      series1.tooltipText = "{name}: {dateX.formatDate('MMM/yyyy')}  [bold]{valueY}[/]";
      series1.bullets.push(new am4charts.CircleBullet());
      var currentDataArray = mySeries[i];
      var data = [];
      for(let j=0;j < currentDataArray.length; j++){
          var currentData = currentDataArray[j];
          var dataItem = { date : new Date(currentData.time) , value : currentData.value };
          data.push(dataItem);
      }
      series1.data = data;
      
    }
}