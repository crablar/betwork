var arr;

$.getJSON("/charts.json", function(json) {
    arr = json;
    for (var i = 0; i < arr.length; i++) {
        var chart = arr[i];
        var events = chart["events"];
        var values = [];
        var timestamps = [];
        for(var j = 1; j < events.length; j++){
            values.push(events[j]["value"]);
            var date = new Date(events[j]["timestamp"]*1000);
            timestamps.push(date);
        }
        chart["events"] = events;
        $(function () {
            new Highcharts.Chart({
                chart: {
                    renderTo: chart["chartSubject"]["subjectName"] + 'Chart'
                },
                title: {
                    text: chart["chartSubject"]["subjectName"],
                    x: -20 //center
                },
                subtitle: {
                    text: 'Source: Facebook.com',
                    x: -20
                },
                xAxis: {
                    categories: timestamps,
                },
                yAxis: {
                    title: {
                        text: chart["chartSubject"]["valueType"]
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
                    name: chart["chartSubject"]["subjectName"],
                    data: values
                }]
            });
        });
    }

}); 
