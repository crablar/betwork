var arr;

$.getJSON("/sample_chart_data.json", function(json) {
    arr = json;
    for (var i = 0; i < arr.length; i++) {
        var chart = arr[i];
        console.log(chart.subjectName);
        $(function () {
            $('#' + chart["subjectName"] + 'Chart').highcharts({
                title: {
                    text: chart.subjectName,
                    x: -20 //center
                },
                subtitle: {
                    text: 'Source: Facebook.com',
                    x: -20
                },
                xAxis: {
                    categories: chart.timestamps,
                },
                yAxis: {
                    title: {
                        text: chart.valueType
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: ' likes'
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: [{
                    name: chart.subjectName,
                    data: chart.values
                }]
            });
        });
    }

}); 
