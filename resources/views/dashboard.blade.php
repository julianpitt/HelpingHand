@extends('layouts.subsites')
@section('content')
    <div class="container subpage">
        <div class="row">
            <div class="col-xs-12">
                <h1>Dashboard</h1>
                <h2 style="margin-top: 80px;">Your Supported Causes</h2>
            </div>
            <div class="col-xs-4 water">
                <section id="howToHelp" class="water">
                    <div id="causes">
                        <div href="javascript:void();" class="help-method">
                            <div class="table-wrapper">
                                <div class="table-inner">
                                    <div class="table-center">
                                        Using water tanks
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <section>
            </div>
            <div class="col-xs-8">
                <div style="padding: 60px;margin-top: 30px; font-size: 1.2em; line-spacing: 2;">
                    Over the past month, you and 14,324 other Helping Hand users have contributed to
                    reducing water usage in your region by 16%!<br><br>
                    <b>Congratulations!</b> You can up the ante by using an ENERGY STAR-rated washing machine and
                    only wash when you have a full load.
                </div>
            </div>
            <div class="col-xs-12">
                <canvas id="myChart" width="400" height="200"></canvas>
                <script type="text/javascript"
                        src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.2.1/Chart.min.js"></script>
                <script>
                    var ctx = document.getElementById("myChart");
                    var data = {
                        labels: ["March", "April", "May", "June", "July", "August"],
                        datasets: [{
                            label: 'Water usage /month',
                            data: [12, 13, 13, 12, 10, 9],
                            backgroundColor: [
                                'rgba(117, 185, 230, 0.2)',
                                'rgba(117, 185, 230, 0.2)',
                                'rgba(117, 185, 230, 0.2)',
                                'rgba(117, 185, 230, 0.2)',
                                'rgba(117, 185, 230, 0.2)',
                                'rgba(117, 185, 230, 0.2)'
                            ],
                            borderColor: [
                                'rgba(117, 185, 230,1)',
                                'rgba(117, 185, 230, 1)',
                                'rgba(117, 185, 230, 1)',
                                'rgba(117, 185, 230, 1)',
                                'rgba(117, 185, 230, 1)',
                                'rgba(117, 185, 230, 1)'
                            ],
                            borderWidth: 1
                        }]
                    };
                    var myChart = new Chart(ctx, {
                        type: 'line',
                        data: data,
                        options: {
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                            }
                        }
                    });
                </script>
            </div>
        </div>
    </div>
@endsection
