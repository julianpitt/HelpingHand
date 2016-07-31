<?php

use App\Models\Action;
use Illuminate\Database\Seeder;

class ActionSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        //Water
        $types = [
            '5 minute Showers',
            'Using water tanks',
            'Water garden in the evening',
            'Only wash clothes on full load'
        ];

        foreach($types as $type) {
            $water = new Action();
            $water->title = $type;
            $water->data_type_id = 1;
            $water->save();
        }


        //Gas
        $types = [
            'Cold showers',
            'Turn off heading before bed',
            'Electric stove tops',
            'Putting clothes when cold'
        ];

        foreach($types as $type) {
            $gas = new Action();
            $gas->title = $type;
            $gas->data_type_id = 2;
            $gas->save();
        }

        //Electricity
        $types = [
            'Use candles',
            'Turn off unused appliances',
            'Open blinds',
            'Purchase solar panels',
        ];

        foreach($types as $type) {
            $electricity = new Action();
            $electricity->title = $type;
            $electricity->data_type_id = 3;
            $electricity->save();
        }

        //Homelessness
        $types = [
            'Donate to a charity',
            'Help at a shelter',
            'Donate spare food',
        ];

        foreach($types as $type) {
            $homelessness = new Action();
            $homelessness->title = $type;
            $homelessness->data_type_id = 4;
            $homelessness->save();
        }
    }
}
