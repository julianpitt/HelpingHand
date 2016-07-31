@extends('layouts.subsites')
@section('content')
<div class="container subpage">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">

                <div class="panel-heading">Register</div>

                <div class="panel-body">

                    {!! Former::open()->method('post')->acion(url('/register')) !!}

                        {{ csrf_field() }}

                        {!! Former::text('email') !!}
                        {!! Former::password('password') !!}
                        {!! Former::password('password_confirmation') !!}

                        {!! Former::submit('Register') !!}

                    {!! Former::close() !!}
                </div>

            </div>
        </div>
    </div>
</div>
@endsection
