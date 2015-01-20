var arr;

$.getJSON("/charts.json", function(json) {
    arr = json;
    console.log(arr);
    for (var i = 0; i < arr.length; i++) {
        var chart = arr[i];
        console.log(chart);
        var events = chart["events"];
        console.log(events);
        for(var j = 1; j < events.length; j++){
            events[j]["value"] -= events[j - 1]["value"];
        }
        events[0] = 0;
        chart["events"] = events;
        console.log(chart);
        $(function () {
            new Highcharts.Chart({
                chart: {
                    renderTo: chart["subjectName"] + 'Chart'
                },
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
