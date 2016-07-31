@extends('layouts.subsites')
@section('content')
    <div class="container subpage">
        <div class="row">
            <div class="col-xs-12">
                <h1>Dashboard</h1>
            </div>
            <div class="col-xs-12 water">
                <h2>Your Supported Causes</h2>
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
            <div class="col-xs-12">
                <canvas id="myChart" width="400" height="400"></canvas>
                <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.2.1/Chart.min.js"></script>
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
                                        beginAtZero:true
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
