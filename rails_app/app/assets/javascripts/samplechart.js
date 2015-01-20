var arr;

$.getJSON("/charts.json", function(json) {
    arr = json;
    console.log(arr);
    for (var i = 0; i < arr.length; i++) {
        var chart = arr[i];
        var events = chart["events"];
        var values = [];
        var timestamps = [];
        for(var j = 1; j < events.length; j++){
            console.log(events[j]);
            //values.push(events[j]["value"] - events[j - 1]["value"]);
            values.push(1);
            timestamps.push(events[j]["timestamp"]);
        }
        chart["events"] = events;
        console.log("YOO");
        console.log(values);
        console.log(timestamps);
        console.log(chart["chartSubject"]["subjectName"]);
        console.log(chart["chartSubject"]["valueType"]);
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
